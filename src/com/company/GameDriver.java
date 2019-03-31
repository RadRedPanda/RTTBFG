package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class GameDriver {

    private Player p;
    private Enemy currentEnemy;
    private EncounterThread bs;
    private CommandHandler handler;
    private Thread encounterChecker;
    private JFrame frame;
    private JPanel mainPanel, inputPanel, playerPanel;
    private JTextField textField;
    private JTextArea gameText, playerText;
    private Action enterPressed;
    private JScrollPane scroll;

    public GameDriver() {

        p = new Player("Knight");
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

        handler = new CommandHandler();

        bs = new EncounterThread();
        Thread t = new Thread(bs);
        t.start();

        enterPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                String[] words = input.split(" ");
                ArrayList<String> inputs = new ArrayList<String>();
                for(int i = 0; i < words.length; i++) {
                    inputs.add(words[i]);
                }
                updateTextField(input);
                if (bs.isInEncounter()) {
                    fightBack(inputs);
                } else {
                    updateGameText(handler.execute(input));
                }
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
        updatePlayerText();

        frame.add(mainPanel, BorderLayout.WEST);
        frame.add(playerPanel);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    public String fightBack(ArrayList<String> command){
        int damage;
        switch(command.get(0)){
            case "block":
                if(!p.isBlocking() && currentEnemy.getAttacking()) {
                    p.setBlocking(true);
                    updateGameText("You get ready to block!");
                }else if(p.isBlocking()){
                    updateGameText("You are already blocking!");
                }else{
                    updateGameText("What are you blocking?");
                }
                break;
            case "attack":
                damage = p.rollAttack();
                currentEnemy.changeHealth(-damage);
                updateGameText("You dealt " + damage + " damage to the " + currentEnemy.getName() + "!");
                if(currentEnemy.getHealth() <= 0) {
                    updateGameText("You killed the " + currentEnemy.getName() + "!");
                    bs.setInEncounter(false);
                }
                break;
            case "use":
                Weapons w = p.searchWeapons(command.get(1));
                if(w != null) {
                    damage = w.rollAttack();
                    currentEnemy.changeHealth(-damage);
                    updateGameText("You hit the " + currentEnemy.getName() + " with a " + w.getWeapon() + " and dealt " + damage + " damage!");
                }else{
                    updateGameText("You don't have a " + command.get(1) + "!");
                }
                break;
            case "run":
                int runAway = (int)(Math.random() * 5);
                if(runAway == 0){
                    updateGameText("You ran away!");
                    bs.setInEncounter(false);
                }else{
                    updateGameText("You couldn't get away!");
                }
                break;
        }
        return "hi";
    }

    public void randomFight() {
        updateGameText("Encounter!");
        currentEnemy = bs.randomEnemy();
        updateGameText("A wild " + currentEnemy.getName() + " has appeared!");
        int cooldown = 0;
        while(currentEnemy.getHealth() > 0 && p.getHealth() > 0){
            if(currentEnemy.getAttacking()){
                if(cooldown++ >= currentEnemy.getAttackDelay()) {
                    int damage = currentEnemy.rollAttack();
                    if (p.isBlocking()) {
                        updateGameText("You blocked " + (damage - (damage / 2)) + " damage!");
                        damage /= 2;
                        p.setBlocking(false);
                    }
                    updateGameText("The " + currentEnemy.getName() + " hit you for " + damage + " damage!");
                    p.changeHealth(-damage);
                    currentEnemy.isAttacking(false);
                    cooldown = 0;
                }
            }else{
                int chance = (int)(Math.random() * currentEnemy.getAttackSpeed());
                if(chance == 0) {
                    updateGameText("The " + currentEnemy.getName() + " is getting ready to attack!");
                    currentEnemy.isAttacking(true);
                }
            }
            updatePlayerText();
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void updateGameText(String s) {
        gameText.setText(gameText.getText() + "\n" + "" + s);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public void updateTextField(String s) {
        textField.setText("");
        gameText.setText(gameText.getText() + "\n\n" + "> " + s);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public void updatePlayerText() {
        playerText.setText("");
        playerText.append("Player Info\n\n");
        playerText.append("\nClass: " + p.getPlayer());
        playerText.append("\n\nHealth: " + p.getHealth());
        playerText.append("\n\nItems:");
        for(int i = 0; i < p.getItems().size(); i++) {
            playerText.append("\n\t" + p.getItems().get(i));
        }
    }

    public static void main(String[] args) {

        GameDriver frame = new GameDriver();

    }

}
