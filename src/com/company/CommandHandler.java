package com.company;
import java.util.*;
public class CommandHandler {
    private int currentRoomX;
    private int currentRoomY;
    private String command;
    private List<ArrayList <Room>> rooms;

    public CommandHandler() {
        rooms = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            rooms.add(new ArrayList<>());
            for(int j = 0; j < 5; j++) {
                rooms.get(i).add(new Room(false));
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

            }

        }

        currentRoomX = 0;
        currentRoomY = 0;

        //Cottage
        rooms.get(0).get(0).setRoomName("Cottage");
        rooms.get(0).get(0).setRoomMessage("You wake up in a small one-room cottage. You are laying on a short cot. There is a suit of armor hanging on the wall and a villager’s tunic spread out on a table. Which do you choose to put on?");
        rooms.get(0).get(0).setDesc("Its a cottage. It smells like cheese");
        rooms.get(0).get(0).setInUse(true);

        //Central
        rooms.get(0).get(1).setRoomName("Central Path");
        rooms.get(0).get(1).setRoomMessage("You're on a path.");
        rooms.get(0).get(1).setDesc("");
        rooms.get(0).get(1).setInUse(true);

        //Lake
        rooms.get(0).get(2).setRoomName("Lake");
        rooms.get(0).get(2).setRoomMessage("You are by the lake.");
        rooms.get(0).get(2).setDesc("");
        rooms.get(0).get(2).setInUse(true);

        //foggy path
        rooms.get(1).get(1).setRoomName("Foggy Path");
        rooms.get(1).get(1).setRoomMessage("You are on a foggy path.");
        rooms.get(1).get(1).setDesc("");
        rooms.get(1).get(1).setInUse(true);

        //forest
        rooms.get(1).get(2).setRoomName("Forest");
        rooms.get(1).get(2).setRoomMessage("You are in a forest.");
        rooms.get(1).get(2).setDesc("");
        rooms.get(1).get(2).setInUse(true);

        //fork
        rooms.get(2).get(2).setRoomName("Fork in the Road");
        rooms.get(2).get(2).setRoomMessage("You are at a fork on the road");
        rooms.get(2).get(2).setDesc("");
        rooms.get(2).get(2).setInUse(true);

        //goblin clearing
        rooms.get(2).get(3).setRoomName("Clearing infested with Goblins!");
        rooms.get(2).get(3).setRoomMessage("You are surrounded by goblins!");
        rooms.get(2).get(3).setDesc("");
        rooms.get(2).get(3).setInUse(true);

        //bat clearing
        rooms.get(3).get(2).setRoomName("Clearing infested with Bats!");
        rooms.get(3).get(2).setRoomMessage("You are surrounded by bats!");
        rooms.get(3).get(2).setDesc("");
        rooms.get(3).get(2).setInUse(true);

    }


    public void setCommand(String commandIn){
        command = commandIn;
    }

    public String getCommand(){
        return command;
    }

    public String execute(String command){
        switch(command){

            case("look"):
                return rooms.get(currentRoomX).get(currentRoomY).getDesc();

            case("move north"):
                if((currentRoomY - 1) < 0) return "The path north is blocked.";
                if(rooms.get(currentRoomX).get(currentRoomY-1).isInUse()) {
                    currentRoomY--;
                    return "You have moved north. You are now at a " + rooms.get(currentRoomX).get(currentRoomY).getRoomName();
                }
                else
                    return "The path north is blocked.";

            case("move west"):
                if((currentRoomX - 1) < 0) return "The path west is blocked.";
                if(rooms.get(currentRoomX-1).get(currentRoomY).isInUse()) {
                    currentRoomX--;
                    return "You have moved west. You are now at a " + rooms.get(currentRoomX).get(currentRoomY).getRoomName();
                }
                else
                    return "The path west is blocked.";

            case("move south"):
                if((currentRoomY + 1) > (rooms.size() - 1)) return "The path south is blocked.";
                if(rooms.get(currentRoomX).get(currentRoomY+1).isInUse()) {
                    currentRoomY++;
                    return "You have moved south. You are now at a " + rooms.get(currentRoomX).get(currentRoomY).getRoomName();
                }
                else
                    return "The path south is blocked.";

            case("move east"):
                if((currentRoomX + 1) > (rooms.size() - 1)) return "The path east is blocked.";
                if(rooms.get(currentRoomX+1).get(currentRoomY).isInUse()) {
                    currentRoomX++;
                    return "You have moved east. You are now at a " + rooms.get(currentRoomX).get(currentRoomY).getRoomName();
                }
                else
                    return "The path east is blocked.";

            default:
                return "Unrecognized command.";

        }

    }

    public String doLook(String command){
    return "";
    }

}
