package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow {

    private Player p;
    private BattleSystem bs;
    private Thread encounterChecker;
    private JFrame frame;
    private JPanel mainPanel, inputPanel, playerPanel;
    private JTextField textField;
    private JTextArea gameText, playerText;
    private Action enterPressed;
    private JScrollPane scroll;

    public GameWindow() {

        p = new Player();
        frame = new JFrame("Game");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setSize(550,700);
        mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        playerPanel = new JPanel();
        playerPanel.setSize(200, 700);
        playerPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        inputPanel = new JPanel();
        inputPanel.setSize(800,100);
        inputPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        enterPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                updateTextField(input);
            }
        };

        textField = new JTextField();
        textField.setEditable(true);
        textField.setPreferredSize(new Dimension(780, 40));
        textField.addActionListener(enterPressed);
        inputPanel.add(textField);

        gameText = new JTextArea("Welcome to the game!\n\n");
        gameText.setEditable(false);
        scroll = new JScrollPane(gameText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(500,690));
        mainPanel.add(scroll);

        playerText = new JTextArea("Player Information:\n\n");
        playerText.setPreferredSize(new Dimension(250, 690));
        playerText.setEditable(false);
        playerPanel.add(playerText);

        bs = new BattleSystem();
        Thread t = new Thread(bs);
        t.start();

        encounterChecker = new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(bs.isInEncounter()) {
                        randomFight();
                        bs.setInEncounter(false);
                    }
                }
            }
        };
        encounterChecker.start();

        frame.add(mainPanel, BorderLayout.WEST);
        frame.add(playerPanel);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    public void randomFight() {
        updateTextField("Encounter!");
        Enemy enemy = bs.randomEnemy();
        while(enemy.getHealth() > 0 && p.GetHealth() > 0){
            updateGameText("A wild " + enemy.getName() + " has appeared!");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void updateGameText(String s) {
        textField.setText("");
        gameText.setText(gameText.getText() + "\n" + "" + s);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public void updateTextField(String s) {
        textField.setText("");
        gameText.setText(gameText.getText() + "\n\n" + "> " + s);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public static void main(String[] args) {

        GameWindow frame = new GameWindow();

    }

}
