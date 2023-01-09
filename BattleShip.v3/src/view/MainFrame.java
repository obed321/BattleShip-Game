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

    public void setupFrame() {
        setSize(width,height);
        setTitle("BattleShip");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new MainPanel(controller,width,height);
        setContentPane(panel);
        setResizable(true);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
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
        if(newPlayer!=null && !newPlayer.equals("")) setTxtName(newPlayer);
        else {
            JOptionPane.showMessageDialog(null,"Invalid name, exiting!");
            System.exit(0);
        }
    }

    public void shotHit(int x, int y) {
        panel.getCenterPanel().shotHit(x,y);
    }

    public void shotMissed(int x, int y) {
        panel.getCenterPanel().shotMissed(x,y);
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
