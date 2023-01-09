// Obed Owusu
//am7360
//Systemtuvecklare

package model.Ships;

public class Destroyer implements IShip {
    private String name;
    private int lives;

    public Destroyer(String name, int lives) {
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
