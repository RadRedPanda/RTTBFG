package com.company;

public class BattleSystem {
    private Thread t;

    public void setUpBattle(Player p){
        BattleRunnable br = new BattleRunnable();
        t = new Thread(br);
    }

    public void startThread(){
        t.start();
    }

    private Enemy pickEnemy(){
        Enemy e = new Enemy(1);
        return e;
    }
}
