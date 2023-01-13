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
    private ActionListener listener;
    private GridLayout layout;

    public CenterPanelGame(Controller controller,int height,int margin) {
        this.controller = controller;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Game"));
        setPreferredSize(new Dimension(500,height));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin,margin,margin,margin);
        setBorder(new CompoundBorder(border,emptyBorder));

        setupPanel();
    }

    private void setupPanel() {
        layout = new GridLayout(controller.getSizeOfBoard(),controller.getSizeOfBoard());
        setLayout(layout);

        buttons = new JButton[controller.getSizeOfBoard()][controller.getSizeOfBoard()];
        listener = new ButtonActionListeners();

        for (int i = 0; i< buttons.length; i++) {
            for (int j = 0; j< buttons[0].length; j++) {
                buttons[i][j] = new JButton("~");
                buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,11));
                buttons[i][j].addActionListener(listener);
                add(buttons[i][j]);
            }
        }
    }

    public void newBoard(int choice) {
        if (choice==1) {
            for (int i = 0; i< buttons.length; i++) {
                for (int j = 0; j< buttons[0].length; j++) {
                    remove(buttons[i][j]);
                }
            }

            layout = new GridLayout(controller.getSizeOfBoard(),controller.getSizeOfBoard());
            setLayout(layout);

            buttons = new JButton[controller.getSizeOfBoard()][controller.getSizeOfBoard()];

            for (int i = 0; i< buttons.length; i++) {
                for (int j = 0; j< buttons[0].length; j++) {
                    buttons[i][j] = new JButton("~");
                    buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,11));
                    buttons[i][j].addActionListener(listener);
                    add(buttons[i][j]);
                }
            }
        }

        else if (choice==2) {
            for (int i = 0; i< buttons.length; i++) {
                for (int j = 0; j< buttons[0].length; j++) {
                    remove(buttons[i][j]);
                }
            }

            layout = new GridLayout(controller.getSizeOfBoard(),controller.getSizeOfBoard());
            setLayout(layout);

            buttons = new JButton[controller.getSizeOfBoard()][controller.getSizeOfBoard()];

            for (int i = 0; i< buttons.length; i++) {
                for (int j = 0; j< buttons[0].length; j++) {
                    buttons[i][j] = new JButton("~");
                    buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,11));
                    buttons[i][j].addActionListener(listener);
                    add(buttons[i][j]);
                }
            }
        }
        revalidate();
        repaint();
    }

    class ButtonActionListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i< buttons.length; i++) {
                for (int j = 0; j< buttons[0].length; j++) {
                    if (e.getSource()== buttons[i][j]) {
                        controller.checkBoard(j,i);
                        buttons[i][j].setEnabled(false);
                        controller.incrementShots();
                    }
                }
            }
        }
    }

    public void reset() {
        for (int i = 0; i< buttons.length; i++) {
            for (int j = 0; j< buttons[0].length; j++) {
                buttons[i][j].setFont(new Font("Courier New",Font.PLAIN,11));
                buttons[i][j].setText("~");
                buttons[i][j].setEnabled(true);
            }
        }
        controller.resetInfo();
    }

    public void shotHit(int i, int j) {
        buttons[j][i].setText("X");
    }

    public void shotMissed(int i, int j) {
        buttons[j][i].setText("O");
    }

}
