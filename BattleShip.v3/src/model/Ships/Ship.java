// Obed Owusu
//am7360
//Systemtuvecklare

package model.Ships;

public abstract class Ship {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("%s",name);
    }
}
