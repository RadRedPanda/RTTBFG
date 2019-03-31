package com.company;
import java.util.*;

public class Player {
    private int health;
    private String PlayerName;
    private List<Weapon> weapons;
    private List<String> items;
    private int currency;
    private boolean blocking;
    private int minAttack;
    private int attackRange;

    public Player(String name){
        health = 100;
        PlayerName = name;
        items = new ArrayList<String>();
        currency = 0;
        blocking = false;
        minAttack = 5;
        attackRange = 3;
    }

    public void setPlayer(String name){
        PlayerName = name;
    }

    public String getPlayer(){
        return PlayerName;
    }

    public void setHealth(int playerHealth){
        health = playerHealth;
    }

    public void changeHealth(int change){
        health += change;
    }

    public int getHealth(){
        return health;
    }

    public List getItems(){
        return items;
    }

    public void addItems(String itemName){
        items.add(itemName);
    }

    public void pickupItem(String itemName) {
        items.add(itemName);
    }

    public void dropItem(String itemName){
        int size = items.size();

        for (int i = 0; i < size; i++) {
            if (itemName == items.get(i)){
                items.remove(i);
                break;
            }
        }
    }

    public boolean isBlocking(){
        return blocking;
    }

    public void setBlocking(boolean block){
        blocking = block;
    }

    public int rollAttack(){
        return (int)(Math.random() * attackRange + minAttack);
    }

    public Weapon searchWeapons(String name){
        for(int i=0; i<weapons.size(); i++){
            if(weapons.get(i).getWeapon().toLowerCase() == name.toLowerCase()){
                return weapons.get(i);
            }
        }
        return null;
    }

    public void giveMoney(int cash){
        currency += cash;
    }

    public int getCurrency(){
        return currency;
    }
}