package com.company;
import java.util.*;

public class Player {
    private int health;
    private String PlayerName;
    private List<Weapons> weapons;
    private List<String> items;
    private int currency;
    private boolean blocking;

    public Player(){
        health = 100;
        PlayerName = "";
        items = new ArrayList<String>();
        currency = 0;
        blocking = false;
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

    public void setItems(String itemName){
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
}