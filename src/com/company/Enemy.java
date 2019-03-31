package com.company;

import java.util.List;

public class Enemy {
    private int health;
    private String enemyName;
    private int minAttack;
    private int maxAttack;
    private List<String> items;
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
                maxAttack = 5;
                attackSpeed = 3;
                break;
            case 1:
                health = 30;
                enemyName = "Troll";
                minAttack = 5;
                maxAttack = 10;
                attackSpeed = 5;
                break;
            case 2:
                health = 10;
                enemyName = "Bat";
                minAttack = 2;
                maxAttack = 4;
                attackSpeed = 2;
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
}
