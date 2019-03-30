package com.company;

public class Enemy {
    private int health;
    private String EnemyName;

    public Enemy(){
        this(1);
    }

    public Enemy(int enemySelect){
        switch(enemySelect){
            case 1:
                health = 15;
                EnemyName = "Goblin";
                break;
            case 2:
                health = 30;
                EnemyName = "Troll";
                break;
        }
    }
}
