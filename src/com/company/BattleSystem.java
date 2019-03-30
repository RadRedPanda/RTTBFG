package com.company;

public class BattleSystem {

    public void startBattle(Player p){

        BattleRunnable br = new BattleRunnable();
        Thread t = new Thread(br);
        t.start();
        
    }

    private Enemy pickEnemy(){
        Enemy e = new Enemy(1);
        return e;
    }
}
