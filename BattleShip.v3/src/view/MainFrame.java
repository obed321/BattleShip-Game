// Obed Owusu
//am7360
//Systemtuvecklare

package view;

import controller.Controller;

import javax.swing.*;

public class MainFrame extends JFrame {
    private int width = 1000;
    private int height = 1000;

    private Controller controller;
    private MainPanel panel;

    public MainFrame(Controller controller) {
        this.controller = controller;
        setupFrame();
    }

    private void setupFrame() {
        setSize(width,height);
        setTitle("BattleShip");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new MainPanel(controller,width,height);
        setContentPane(panel);
        setResizable(false);

        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public String getTxtName() {
        return panel.getWestPanel().getTxtName();
    }

    public void setTxtName(String name) {
        panel.getWestPanel().setTxtName(name);
    }

    public void setTxtFired(String fired) {
        panel.getWestPanel().setTxtFired(fired);
    }

    public void setTxtShotsHit(String hits) {
        panel.getWestPanel().setTxtShotsHit(hits);
    }

    public void setTxtMissed(String missed) {
        panel.getWestPanel().setTxtMissed(missed);
    }

    public void resetButtons() {
        panel.getCenterPanel().reset();
    }

    public void updateLeaderBoard(String[] list) {
        panel.getEastPanel().updateLeaderboard(list);
    }

    public void newPlayer() {
        String newPlayer = JOptionPane.showInputDialog("Name?");
        if (newPlayer!=null && !newPlayer.equals("")) {
            panel.getWestPanel().setTxtName(newPlayer);
            String choice = JOptionPane.showInputDialog("8x8 (1) or 10x10 (2)");
            try {
                if (Integer.parseInt(choice)==1 || Integer.parseInt(choice)==2) {
                    controller.createBoard(Integer.parseInt(choice));
                    panel.getCenterPanel().newBoard(Integer.parseInt(choice));
                    controller.placeShips(Integer.parseInt(choice));

                }
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

    public void shotHit(int i, int j) {
        panel.getCenterPanel().shotHit(i,j);
    }

    public void shotMissed(int i, int j) {
        panel.getCenterPanel().shotMissed(i,j);
    }

    public void setTxtNeed(String need) {
        panel.getWestPanel().setTxtNeed(need);
    }

    public void shipSank(String ship) {
        JOptionPane.showMessageDialog(null,"You sunk a "+ship);
    }

    public void hitShip(String ship, int lives) {
        JOptionPane.showMessageDialog(null,"You hit a "+ship+" "+lives+" hit remain");
    }
}
