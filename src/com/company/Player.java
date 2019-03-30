package com.company;
import java.util.*;
// Health
// Items
public class Player {
    private int health;
    private String PlayerName;
    private List<String> items;
    private int currency;

    public Player(){
        health = 100;
        PlayerName = "";
        items = new ArrayList<String>();
        currency = 0;
    }

    public void SetPlayer(String name){
        PlayerName = name;
    }

    public String GetPlayer(){
        return PlayerName;
    }

    public void SetHealth(int player_health){
        health = player_health;
    }

    public int GetHealth(){
        return health;
    }

    public List GetItems(){
        return items;
    }

    public void PickupItem(String item_name) {
        items.add(item_name);
    }

    public void DropItem(String item_name){
        int size = items.size();

        for (int i = 0; i < size; i++) {
            if (item_name == items.get(i)){
                items.remove(i);
                break;
            }
        }
    }




}