package com.company;
import java.util.*;
public class Weapons {
    private List<String> items;
    private int minDamage, maxDamage;

    public List getItems(){ return items; }

    public void setItems(String item){items.add(item);}

    public int getMinDamage(){return minDamage;}

    public void setMinDamage(int damage){minDamage = damage;}

    public int getMaxDamage(){return maxDamage;}

    public void setMaxDamage(int damage){maxDamage = damage;}




}
