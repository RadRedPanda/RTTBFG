package com.company;

public class BattleSystem implements Runnable {

    private boolean inEncounter = false;

    public BattleSystem() {}

    private Enemy pickEnemy(){
        Enemy e = new Enemy(1);
        return e;
    }

    public boolean isInEncounter() {
        return inEncounter;
    }

    public void setInEncounter(boolean b) {
        inEncounter = b;
    }

    @Override
    public void run() {
        while(true) {
            int x = (int)(Math.random() * 20) + 1;
            if(x == 5) {
                inEncounter = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
