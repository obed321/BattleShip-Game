// Obed Owusu
//am7360
//Systemtuvecklare

package controller;

import javax.swing.*;

public class MainProgram {
    public static void main(String[] args) {
        Controller controller;

        String name = JOptionPane.showInputDialog("Name?");
        if (name!=null) controller = new Controller(name);
        else {
            JOptionPane.showMessageDialog(null,"Name is invalid! Exiting!");
            System.exit(0);
        }

        //controller = new Controller();
    }
}
