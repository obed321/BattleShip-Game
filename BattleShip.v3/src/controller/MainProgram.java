// Obed Owusu
//am7360
//Systemtuvecklare

package controller;

import javax.swing.*;

public class MainProgram {
    public static void main(String[] args) {
        Controller controller;

        String name = JOptionPane.showInputDialog("Name?");
        if (name!=null && !name.equals("")) {
            String choice = JOptionPane.showInputDialog("8x8 (1) or 10x10 (2)");
            try {
                if (Integer.parseInt(choice)==1 || Integer.parseInt(choice)==2) controller = new Controller(name,Integer.parseInt(choice));
                else {
                    JOptionPane.showMessageDialog(null,"Invalid! Exiting!");
                    System.exit(0);
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Invalid! Exiting!");
                System.exit(0);
            }
        }

        else {
            JOptionPane.showMessageDialog(null,"Invalid! Exiting!");
            System.exit(0);
        }
    }
}
