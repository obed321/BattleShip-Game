// Obed Owusu
//am7360
//Systemtuvecklare

package model;

public class Player {
    private String name;
    private double score;

    public Player(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String toString() {
        return String.format("%s %.2f",name,score);
    }
}
