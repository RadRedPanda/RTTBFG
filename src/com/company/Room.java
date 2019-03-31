package com.company;
import java.util.*;
public class Room {

    private List<String> items;
    private String name;
    private String roomMessage;
    private String desc;
    private boolean inUse;

    public Room(boolean b){
        items = new ArrayList<>();
        roomMessage = "";
        desc = "";
        name = "";
        inUse = b;
    }

    public void setRoomName(String n) {
        name = n;
    }

    public String getRoomName() {
        return name;
    }

    public void setRoomMessage(String desc){
        roomMessage = desc;
    }
    public String getRoomMessage(){
        return roomMessage;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }

    public void setItems(String item){
        items.add(item);
    }

    public List<String> getItems(){
        return items;
    }

    public void setInUse(boolean b) {
        inUse = b;
    }

    public boolean isInUse() {
        return inUse;
    }


}
