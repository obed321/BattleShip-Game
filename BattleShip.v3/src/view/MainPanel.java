// Obed Owusu
//am7360
//Systemtuvecklare

package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    private int width;
    private int height;

    private Controller controller;
    private WestPanelPlayer westPanel;
    private CenterPanelGame centerPanel;
    private EastPanelLeaderboard eastPanel;
    private BorderLayout layout;

    public MainPanel(Controller controller,int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;
        setupPanel();
    }

    public void setupPanel() {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6,6,6,6);
        setBorder(new CompoundBorder(border,margin));

        westPanel = new WestPanelPlayer(controller,4*height/10,6);
        add(westPanel,BorderLayout.WEST);

        centerPanel = new CenterPanelGame(controller,4*height/10,6);
        add(centerPanel,BorderLayout.CENTER);

        eastPanel = new EastPanelLeaderboard(controller,4*height/10,6);
        add(eastPanel,BorderLayout.EAST);
    }

    public WestPanelPlayer getWestPanel() {
        return westPanel;
    }

    public CenterPanelGame getCenterPanel() {
        return centerPanel;
    }

    public EastPanelLeaderboard getEastPanel() {
        return eastPanel;
    }
}
