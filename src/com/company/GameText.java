package com.company;
import java.util.*;
public class GameText {
    private int currentroomX;
    private int currentroomY;
    private String command;
    private List<ArrayList <Rooms>> rooms;



    public GameText() {
        rooms = new ArrayList<>();
        rooms.add(new ArrayList<>());
        rooms.get(0).add(new Rooms());

        currentroomX = 0;
        currentroomY = 0;

        //Cottage
        rooms.get(0).get(0).SetRoomMessage("You wake up in a small one-room cottage. You are laying on a short cot. There is a suit of armor hanging on the wall and a villager’s tunic spread out on a table. Which do you choose to put on?");
        rooms.get(0).get(0).SetDesc("Its a cottage. It smells like cheese");
        rooms.get(0).get(0).SetItems("testitem"); //REMOVE LATER

        //Central
        rooms.get(0).get(1).SetRoomMessage();
        rooms.get(0).get(1).SetDesc();
        rooms.get(0).get(1).SetItems();

        //Lake
        rooms.get(0).get(2).SetRoomMessage();
        rooms.get(0).get(2).SetDesc();
        rooms.get(0).get(2).SetItems();

        //foggy path
        rooms.get(1).get(1).SetRoomMessage();
        rooms.get(1).get(1).SetDesc();
        rooms.get(1).get(1).SetItems();

        //forest
        rooms.get(1).get(2).SetRoomMessage();
        rooms.get(1).get(2).SetDesc();
        rooms.get(1).get(2).SetItems();

        //fork
        rooms.get(2).get(2).SetRoomMessage();
        rooms.get(2).get(2).SetDesc();
        rooms.get(2).get(2).SetItems();

        //goblin clearing
        rooms.get(2).get(3).SetRoomMessage();
        rooms.get(2).get(3).SetDesc();
        rooms.get(2).get(3).SetItems();

        //bat clearing
        rooms.get(3).get(2).SetRoomMessage();
        rooms.get(3).get(2).SetDesc();
        rooms.get(3).get(2).SetItems();

    }

    public void SetCommand(String command_in){
        command = command_in;
    }

    public String GetCommand(){
        return command;
    }


    public void execute(String command){
        switch(command){

            case("look"):
                rooms.get(currentroomX).get(currentroomY).GetDesc();
                break;

            case("north"):
                currentroomY++;


    }


    }
    public String DoLook(String command){
    return "";
    }




}
