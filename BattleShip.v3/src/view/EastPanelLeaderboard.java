// Obed Owusu
//am7360
//Systemtuvecklare

package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class EastPanelLeaderboard extends JPanel {
    private int height;
    private Controller controller;

    private JList<String> list;

    public EastPanelLeaderboard(Controller controller, int height, int margin) {
        this.controller = controller;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Leaderboard"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin,margin,margin,margin);
        setBorder(new CompoundBorder(border,emptyBorder));

        setupPanel();
    }

    private void setupPanel() {
        list = new JList<>();
        Font font = new Font("Courier New",Font.PLAIN,11);
        list.setFont(font);
        JScrollPane s = new JScrollPane(list);

        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        s.setPreferredSize(new Dimension(200,height));

        add(s);
    }

    public void updateLeaderboard(String[] stringList) {
        list.setListData(stringList);
    }
}
