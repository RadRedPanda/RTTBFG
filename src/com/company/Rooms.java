package com.company;
import java.util.*;
public class Rooms {

    private List<String> items;
    private String RoomMessage;
    private String Desc;

    public Rooms(){
        RoomMessage = "";
        Desc = "";
    }

    public void SetRoomMessage(String desc){
        RoomMessage = desc;
    }
    public String GetRoomMessage(){
        return RoomMessage;
    }

    public void SetDesc(String desc){
        Desc = desc;
    }

    public String GetDesc(){
        return Desc;
    }

    public void SetItems(String item){
        items.add(item);
    }

    public List GetItems(){
        return items;
    }



}
