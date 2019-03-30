package com.company;

import java.util.List;

public class Enemy {
    private int health;
    private String enemyName;
    private int minAttack;
    private int maxAttack;
    private List<String> items;
    private int currency;

    public Enemy(){
        this(0);
    }

    public Enemy(int enemySelect){
        switch(enemySelect){
            case 0:
                health = 15;
                enemyName = "Goblin";
                minAttack = 3;
                maxAttack = 5;
                break;
            case 1:
                health = 30;
                enemyName = "Troll";
                minAttack = 5;
                maxAttack = 10;
                break;
        }
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return enemyName;
    }

    public int rollAttack(){
        return (int)(Math.random() * (maxAttack + 1 - minAttack)) + minAttack;
    }
}
