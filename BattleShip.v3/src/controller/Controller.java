// Obed Owusu
//am7360
//Systemtuvecklare

package controller;

import model.GameBoard;
import model.LeaderBoardManager;
import model.Ships.*;
import view.MainFrame;

public class Controller {
    private MainFrame view;
    private GameBoard gameBoard;
    private LeaderBoardManager leaderBoardManager;

    private Submarine submarine;
    private TorpedoBoat torpedoBoat;
    private Destroyer destroyer;
    private Cruiser cruiser;
    private Battleship battleship;

    private int nbrOfShots;
    private int nbrOfHits;
    private int nbrOfMissed;
    private int shotsNeeded;

    public Controller(String name) {
        gameBoard = new GameBoard(10);
        leaderBoardManager = new LeaderBoardManager();
        view = new MainFrame(this);
        view.setTxtName(name);
        printLeaderBoard();
        placeShips();
    }



    private void placeShips() {
        submarine = new Submarine("Submarine",1);
        gameBoard.addShip(submarine,0,0);

        torpedoBoat = new TorpedoBoat("TorpedoBoat",2);
        gameBoard.addShip(torpedoBoat,1,1);
        gameBoard.addShip(torpedoBoat,2,1);

        destroyer = new Destroyer("Destroyer",3);
        gameBoard.addShip(destroyer,0,4);
        gameBoard.addShip(destroyer,0,5);
        gameBoard.addShip(destroyer,0,6);

        cruiser = new Cruiser("Cruiser",4);
        gameBoard.addShip(cruiser,4,7);
        gameBoard.addShip(cruiser,5,7);
        gameBoard.addShip(cruiser,6,7);
        gameBoard.addShip(cruiser,7,7);

        battleship = new Battleship("Battleship",5);
        gameBoard.addShip(battleship,7,1);
        gameBoard.addShip(battleship,7,2);
        gameBoard.addShip(battleship,7,3);
        gameBoard.addShip(battleship,7,4);
        gameBoard.addShip(battleship,7,5);

        shotsNeeded += submarine.getLives() + torpedoBoat.getLives()+ destroyer.getLives() +
                cruiser.getLives() + battleship.getLives();

        view.setTxtNeed(Integer.toString(shotsNeeded));

    }


    private void printLeaderBoard() {
        String[] info = leaderBoardManager.getLeaderBoard();
        for (String s : info) System.out.println(s);
    }

    public void checkBoard(int x, int y) {
        IShip[][] test = gameBoard.getShips();

        if (test[x][y]!=null) {
            incrementHits();
            decrementShotsNeeded();
            view.shotHit(x,y);

            switch (test[x][y].getName()) {
                case "Submarine":
                    view.shipSank("Submarine");
                    break;
                case "TorpedoBoat":
                    if (torpedoBoat.isHit()) {
                        view.hitShip("TorpedoBoat", torpedoBoat.getLives());
                        if (torpedoBoat.isSunk()) view.shipSank("TorpedoBoat");
                    }
                    break;
                case "Destroyer":
                    if (destroyer.isHit()) {
                        view.hitShip("Destroyer", destroyer.getLives());
                        if (destroyer.isSunk()) view.shipSank("Destroyer");
                    }
                    break;
                case "Cruiser":
                    if (cruiser.isHit()) {
                        view.hitShip("Cruiser", cruiser.getLives());
                        if (cruiser.isSunk()) view.shipSank("Cruiser");
                    }
                    break;
                case "Battleship":
                    if (battleship.isHit()) {
                        view.hitShip("Battleship", battleship.getLives());
                        if (battleship.isSunk()) view.shipSank("Battleship");
                    }
                    break;
            }
        }

        else if(test[x][y] == null)
        {
            incrementMisses();
            view.shotMissed(x,y);
        }

        else {
            resetInfo();
        }
    }

    public void incrementShots() {
        nbrOfShots++;
        view.setTxtFired(Integer.toString(nbrOfShots));
    }

    public void incrementHits() {
        nbrOfHits++;
        view.setTxtShotsHit(Integer.toString(nbrOfHits));
    }

    public void incrementMisses() {
        nbrOfMissed++;
        view.setTxtMissed(Integer.toString(nbrOfMissed));
    }

    private void decrementShotsNeeded() {
        shotsNeeded--;
        view.setTxtNeed(Integer.toString(shotsNeeded));
        if (shotsNeeded==0) {
            newGame();

        }
    }

    public void resetInfo() {
        nbrOfShots = 0;
        nbrOfHits = 0;
        nbrOfMissed = 0;
        shotsNeeded = 0;

        placeShips();


        view.setTxtFired(Integer.toString(0));
        view.setTxtShotsHit(Integer.toString(0));
        view.setTxtMissed(Integer.toString(0));
        decrementShotsNeeded();
    }

    public int getSizeOfBoard() {
        return gameBoard.getSizeOfBoard();
    }

    public void newGame() {
        double score = (double)nbrOfHits/(double)nbrOfShots;

        leaderBoardManager.addPlayer(view.getTxtName(),score);
        view.updateLeaderBoard(leaderBoardManager.getLeaderBoard());
        view.resetButtons();
        resetInfo();
        view.newPlayer();
    }

}
