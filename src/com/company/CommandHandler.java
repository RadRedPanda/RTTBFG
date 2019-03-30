package com.company;
import java.util.*;
public class CommandHandler {
    private int currentRoomX;
    private int currentRoomY;
    private String command;
    private List<ArrayList <Room>> rooms;

    public CommandHandler() {
        rooms = new ArrayList<>();
        rooms.add(new ArrayList<>());
        rooms.get(0).add(new Room());

        currentRoomX = 0;
        currentRoomY = 0;

        //Cottage
        rooms.get(0).get(0).setRoomMessage("You wake up in a small one-room cottage. You are laying on a short cot. There is a suit of armor hanging on the wall and a villager’s tunic spread out on a table. Which do you choose to put on?");
        rooms.get(0).get(0).setDesc("Its a cottage. It smells like cheese");
        rooms.get(0).get(0).setItems("testitem"); //REMOVE LATER

        //Central
        rooms.get(0).get(1).setRoomMessage("");
        rooms.get(0).get(1).setDesc("");
        rooms.get(0).get(1).setItems("");

        //Lake
        rooms.get(0).get(2).setRoomMessage("");
        rooms.get(0).get(2).setDesc("");
        rooms.get(0).get(2).setItems("");

        //foggy path
        rooms.get(1).get(1).setRoomMessage("");
        rooms.get(1).get(1).setDesc("");
        rooms.get(1).get(1).setItems("");

        //forest
        rooms.get(1).get(2).setRoomMessage("");
        rooms.get(1).get(2).setDesc("");
        rooms.get(1).get(2).setItems("");

        //fork
        rooms.get(2).get(2).setRoomMessage("");
        rooms.get(2).get(2).setDesc("");
        rooms.get(2).get(2).setItems("");

        //goblin clearing
        rooms.get(2).get(3).setRoomMessage("");
        rooms.get(2).get(3).setDesc("");
        rooms.get(2).get(3).setItems("");

        //bat clearing
        rooms.get(3).get(2).setRoomMessage("");
        rooms.get(3).get(2).setDesc("");
        rooms.get(3).get(2).setItems("");

    }

    public void SetCommand(String commandIn){
        command = commandIn;
    }

    public String GetCommand(){
        return command;
    }

    public void execute(String command){
        switch(command){

            case("look"):
                rooms.get(currentRoomX).get(currentRoomY).getDesc();
                break;

            case("north"):
                currentRoomY++;

        }

    }

    public String DoLook(String command){
    return "";
    }

}
