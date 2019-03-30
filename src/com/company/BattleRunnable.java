package com.company;

public class BattleRunnable implements Runnable{


    public void run(){

        fightLoop();
    }

    private void fightLoop(){
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
}
