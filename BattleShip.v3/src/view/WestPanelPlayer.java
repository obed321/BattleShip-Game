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

public class WestPanelPlayer extends JPanel {
    private int height;
    private Controller controller;

    private JPanel pnlLeft;
    private JPanel pnlCenter;

    private JLabel txtName;
    private JLabel txtShotsHit;
    private JLabel txtNeed;

    private JLabel txtFired;
    private JLabel txtMissed;

    private JButton btnNew;

    public WestPanelPlayer(Controller controller, int height, int margin) {
        this.controller = controller;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Player"));
        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin,margin,margin,margin);
        setBorder(new CompoundBorder(border,emptyBorder));

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(200,height));
        createComponents();
    }

    private void createComponents() {
        createComponentsOnLeftPanel();
        createComponentsOnCenterPanel();
    }

    public void createComponentsOnLeftPanel() {
        JLabel lblName = new JLabel("Name: ");
        JLabel lblNeed = new JLabel("Shots needed: ");
        JLabel lblFired = new JLabel("Shots fired: ");

        JLabel lblShotsHit = new JLabel("Shots hit: ");
        JLabel lblMissed = new JLabel("Shots missed: ");

        JLabel lblXHit = new JLabel("X = Hit");
        JLabel lblMiss = new JLabel("O = Miss");
        JLabel lblScore = new JLabel("Score = Hit/Fired");

        btnNew = new JButton("New Game");

        GridLayout layoutLeft = new GridLayout(10,1);

        pnlLeft = new JPanel(layoutLeft);
        pnlLeft.add(lblName);
        pnlLeft.add(lblNeed);
        pnlLeft.add(lblFired);

        pnlLeft.add(lblShotsHit);
        pnlLeft.add(lblMissed);

        pnlLeft.add(lblXHit);
        pnlLeft.add(lblMiss);
        pnlLeft.add(lblScore);

        pnlLeft.add(btnNew);

        addListeners();

        add(pnlLeft,BorderLayout.WEST);
    }

    public void createComponentsOnCenterPanel() {
        txtName = new JLabel("name");
        txtNeed = new JLabel("0");
        txtFired = new JLabel("0");
        txtShotsHit = new JLabel("0");
        txtMissed = new JLabel("0");

        GridLayout layoutRight = new GridLayout(10,1);

        pnlCenter = new JPanel(layoutRight);

        pnlCenter.add(txtName);
        pnlCenter.add(txtNeed);
        pnlCenter.add(txtFired);

        pnlCenter.add(txtShotsHit);
        pnlCenter.add(txtMissed);

        add(pnlCenter,BorderLayout.CENTER);
    }

    public void addListeners() {
        ActionListener listener = new ButtonActionListeners();
        btnNew.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnNew) controller.newGame();
        }
    }

    public String getTxtName() {
        return txtName.getText();
    }
    public void setTxtName(String name) {
        txtName.setText(name);
    }
    public String getTxtShotsHit() {
        return txtShotsHit.getText();
    }
    public void setTxtShotsHit(String shotsHit) {
        txtShotsHit.setText(shotsHit);
    }

    public String getTxtNeed() {
        return txtNeed.getText();
    }
    public void setTxtNeed(String needed) {
        txtNeed.setText(needed);
    }
    public String getTxtFired() {
        return txtFired.getText();
    }
    public void setTxtFired(String fired) {
        txtFired.setText(fired);
    }

    public String getTxtMissed() {
        return txtMissed.getText();
    }
    public void setTxtMissed(String missed) {
        txtMissed.setText(missed);
    }
}
