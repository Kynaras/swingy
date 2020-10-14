package swingy.controller;

import java.util.Random;

import swingy.model.Cyclops;
import swingy.model.Lich;
import swingy.model.Medusa;
import swingy.model.Monster;

public class MonsterFactory {
    private String[] monsterList = {"cyclops", "lich", "medusa"};

    public MonsterFactory() {
        //Todo
    }

    public Monster generateMonster(){
        int rnd = new Random().nextInt(monsterList.length);
        switch (monsterList[rnd]) {
            case "cyclops":
            return new Cyclops();
            case "lich":
            return new Lich();
            case "medusa":
            return new Medusa();
            default:
            return new Monster();
        }
    }
    
}
