// Obed Owusu
//am7360
//Systemtuvecklare

package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterPanelGame extends JPanel {
    private int height;
    private Controller controller;

    private JButton[][] buttons;

    public CenterPanelGame(Controller controller,int height,int margin) {
        this.controller = controller;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Game"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin,margin,margin,margin);
        setBorder(new CompoundBorder(border,emptyBorder));

        setupPanel();
    }

    public void setupPanel() {
        GridLayout layout = new GridLayout(controller.getSizeOfBoard(),controller.getSizeOfBoard());
        setLayout(layout);

        buttons = new JButton[controller.getSizeOfBoard()][controller.getSizeOfBoard()];
        ActionListener listener = new ButtonActionListeners();

        for (int i=0; i<buttons.length; i++) {
            for (int j=0; j<buttons[0].length; j++) {
                buttons[i][j] = new JButton("~");
                buttons[i][j].addActionListener(listener);
                add(buttons[i][j]);
            }
        }
    }

   public class ButtonActionListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<buttons.length; i++) {
                for (int j=0; j<buttons[i].length; j++) {
                    if (e.getSource()==buttons[i][j]) {
                        buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,9));
                        controller.checkBoard(i,j);
                        buttons[i][j].setEnabled(false);
                        controller.incrementShots();
                    }
                }
            }
        }
    }

    public void reset() {
        for (int i=0; i<buttons.length; i++) {
            for (int j=0; j<buttons[i].length; j++) {
                buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,9));
                buttons[i][j].setText("~");
                buttons[i][j].setEnabled(true);
            }
        }
        controller.resetInfo();

    }

    public void shotHit(int x, int y) {
        buttons[x][y].setText("X");
    }

    public void shotMissed(int x, int y) {
        buttons[x][y].setText("O");
    }

}
