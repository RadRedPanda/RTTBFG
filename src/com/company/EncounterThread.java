package com.company;

public class EncounterThread implements Runnable {

    private boolean inEncounter = false;

    public EncounterThread() {}

    public Enemy randomEnemy(){
        Enemy e = new Enemy((int)(Math.random() * 3));
        return e;
    }

    public Enemy fightEnemy(int selection){
        Enemy e = new Enemy(selection);
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
