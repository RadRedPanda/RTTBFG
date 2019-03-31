package com.company;
import java.util.*;
public class Weapons {
    private String weapon;
    private int minDamage, maxDamage;

    public Weapons(){
        weapon = "";
        minDamage = 0;
        maxDamage = 0;
    }

    public String getItems(){return weapon;}

    public void setItems(String weapon_name){weapon = weapon_name;}

    public int getMinDamage(){return minDamage;}

    public void setMinDamage(int damage){minDamage = damage;}

    public int getMaxDamage(){return maxDamage;}

    public void setMaxDamage(int damage){maxDamage = damage;}

    public String getWeapon(){
        return weapon;
    }

    public int rollAttack(){
        return (int)(Math.random() * (maxDamage + 1 - minDamage) + minDamage);
    }
}
