package swingy.model;

import java.util.*;  

public class Dungeon {
    private List<Room> map;
    private Integer currentRoom;
    private Integer previousRoom;
    private Integer dimensions;

    public Dungeon(List<Room> dungeon, int size) {
        this.map = dungeon;
        this.currentRoom = (size * size / 2) + 1;
        this.dimensions = size;
    }

    public List<Room> getMap() {
        return map;
    }

    public Integer getCurrentRoom() {
        return currentRoom;
    }

    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    public void setCurrentRoom(Integer currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setPreviousRoom(Integer previousRoom) {
        this.previousRoom = previousRoom;
    }

    public Integer getPreviousRoom() {
        return previousRoom;
    }
    
}
