// Obed Owusu
//am7360
//Systemtuvecklare

package model.Ships;

public class Cruiser implements IShip {
    private String name;
    private int lives;

    public Cruiser(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public boolean isHit() {
        lives--;
        return true;
    }

    @Override
    public boolean isSunk() {
        return lives == 0;
    }

    public String toString() {
        return String.format("%s",name);
    }
}
