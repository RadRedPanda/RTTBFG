package com.company;
import java.util.*;
public class Room {

    private List<String> items;
    private String RoomMessage;
    private String Desc;

    public Room(){
        RoomMessage = "";
        Desc = "";
    }

    public void setRoomMessage(String desc){
        RoomMessage = desc;
    }
    public String getRoomMessage(){
        return RoomMessage;
    }

    public void setDesc(String desc){
        Desc = desc;
    }

    public String getDesc(){
        return Desc;
    }

    public void setItems(String item){
        items.add(item);
    }

    public List getItems(){
        return items;
    }



}
