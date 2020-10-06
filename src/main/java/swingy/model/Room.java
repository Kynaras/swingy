package swingy.model;

import java.util.Random;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import swingy.controller.MonsterFactory;

public class Room {

    @NotNull
    @Min(1)
    public Integer id;
    @Min(1)
    public Integer north;
    @Min(1)
    public Integer south;
    @Min(1)
    public Integer west;
    @Min(1)
    public Integer east;
    public Monster monster = null;

    public Room(int id, int size) {
            this.id = id;
            this.north = (id - size) < 1 ? null : id - size;
            this.south = (id + size) > (size * size) ? null : id + size;
            this.west = ( ((id - 1) % size) == 0) ? null : id - 1; 
            this.east = id % size == 0 ? null : id + 1;

            if (new Random().nextInt(3) == 2) {
                if(this.id != ((size * size / 2) + 1) )
                    this.monster = new MonsterFactory().generateMonster();
            }
        }

}
