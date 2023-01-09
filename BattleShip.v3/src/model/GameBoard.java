// Obed Owusu
//am7360
//Systemtuvecklare

package model;

import model.Ships.IShip;

public class GameBoard {
    private int sizeOfBoard;
    private IShip[][] ships;

    public GameBoard(int boardSize) {
        sizeOfBoard = boardSize;
        ships = new IShip[sizeOfBoard][sizeOfBoard];
    }

    public void addShip(IShip ship, int row, int col) {
        if (ship!=null) {
            ships[row][col] = ship;
        }
    }

    public IShip[][] getShips() {
        return ships;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

}
