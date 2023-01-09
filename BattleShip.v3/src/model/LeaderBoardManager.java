// Obed Owusu
//am7360
//Systemtuvecklare

package model;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardManager {
    private List<Player> players = new ArrayList<>();

    public void addPlayer(String name, double score) {
        if (!name.equals("")) {
            players.add(new Player(name,score));
            sortLeaderBoard();
        }

    }

    private void sortLeaderBoard() {
        players.sort((o1, o2) -> o1.getScore() > o2.getScore() ? -1 : 1);
    }

    public String[] getLeaderBoard() {
        Player[] playerList = players.toArray(Player[]::new);
        String[] leaderBoard = new String[playerList.length];
        for (int i=0; i<playerList.length; i++) leaderBoard[i] = playerList[i].toString();
        return leaderBoard;
    }

}
