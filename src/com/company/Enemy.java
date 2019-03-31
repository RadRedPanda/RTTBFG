package com.company;

import java.util.List;

public class Enemy {
    private int health;
    private String enemyName;
    private int minAttack;
    private int attackRange;
    private List<String> dropTable;
    private int currency;
    private int attackSpeed;
    private int attackDelay;
    private boolean attacking;

    public Enemy(){
        this(0);
    }

    public Enemy(int enemySelect){
        attackDelay = 2;
        switch(enemySelect){
            case 0:
                health = 15;
                enemyName = "Goblin";
                minAttack = 3;
                attackRange = 2;
                attackSpeed = 3;
                currency = 5;
                break;
            case 1:
                health = 30;
                enemyName = "Troll";
                minAttack = 5;
                attackRange = 5;
                attackSpeed = 5;
                currency = 10;
                break;
            case 2:
                health = 10;
                enemyName = "Bat";
                minAttack = 2;
                attackRange = 2;
                attackSpeed = 2;
                currency = 2;
                break;
        }
    }

    public int getHealth(){
        return health;
    }

    public void changeHealth(int change){
        health += change;
    }

    public String getName(){
        return enemyName;
    }

    public int rollAttack(){
        return (int)(Math.random() * attackRange) + minAttack;
    }

    public int getAttackSpeed(){
        return attackSpeed;
    }

    public void isAttacking(boolean attack){
        attacking = attack;
    }

    public boolean getAttacking(){
        return attacking;
    }

    public int getAttackDelay(){
        return attackDelay;
    }

    public String rollDrop(){
        return dropTable.get((int)(Math.random() * dropTable.size()));
    }

    public int getCurrency(){
        return currency;
    }
}
