package swingy.controller;

import java.util.*;  
import swingy.model.Room;

public class CreateMap {



    public CreateMap() {
        //todo
    }
    public List<Room> setup(int heroLevel) {
        int rowCount = (heroLevel-1)*5+10-(heroLevel%2);
        int roomCount = rowCount * rowCount;
        int size = roomCount;
        int idCounter = 1;
        List<Room> dungeon = new ArrayList<>();


        while (roomCount > 0) {
            dungeon.add(new Room(idCounter, rowCount));
            roomCount--;
            idCounter++;
        }

        return dungeon;
   }
    
}
