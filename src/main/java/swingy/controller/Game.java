package swingy.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import swingy.model.Dungeon;
import swingy.model.Hero;
import swingy.model.Monster;
import swingy.model.Room;
import swingy.model.SaveSystem;
import swingy.model.artefacts.Artefact;
import swingy.utilities.InputUtility;

public class Game {
    private Dungeon dungeon;
    private Hero hero;
    private boolean mapCleared = false;
    private boolean waitUserMove = true;
    private Battle battle = new Battle();
    private ArtefactFactory artefactFactory = new ArtefactFactory();

    public Game(Dungeon dungeon, Hero hero) {
        this.dungeon = dungeon;
        this.hero = hero;
    }

    public void startGame() {
        while (this.mapCleared == false) {
            System.out.println("You're currently in a dungeon. Find the exit!");
            System.out.println("You are in room" + dungeon.getCurrentRoom());
            System.out.println("Pick a direction to go in. Your options are:\n1. North\n2. South\n3. East\n4. West");
            waitUserMove();
            checkRoomStatus();
        }
    }

    public void waitUserMove() {
        while (this.waitUserMove) {
            switch (InputUtility.getUserInput()) {
                case "1":
                    dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                    dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).north);
                    this.waitUserMove = false;
                    break;
                case "2":
                    dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                    dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).south);
                    this.waitUserMove = false;
                    break;
                case "3":
                    dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                    dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).east);
                    this.waitUserMove = false;
                    break;
                case "4":
                    dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                    dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).west);
                    this.waitUserMove = false;
                    break;
                default:
                    System.out.println("Please select one of the valid options only");
                    break;
            }
        }

    }

    public void checkRoomStatus() {
        boolean getUserInput = true;
        if (this.dungeon.getCurrentRoom() == null) {
            System.out.println("You escaped! Would you like to save your hero before we continue?");
            System.out.println("1. Yes\n2. No");
            while (getUserInput) {
                switch (InputUtility.getUserInput()) {
                    case "1":
                        new SaveSystem().saveHero(this.hero);
                        getUserInput = false;
                        break;
                    case "2":
                        getUserInput = false;
                        System.out.println(
                                "Okay, we won't be savng your hero then. Remember that you can only save at the end of each dungeon");
                        break;
                    default:
                        System.out.println("Please select a valid option. 1 or 2!");
                        break;
                }
            }
            CreateMap mapper = new CreateMap();
            this.dungeon = new Dungeon(mapper.setup(this.hero.getLevel()),
                    InputUtility.getMapsize(this.hero.getLevel()));
        } else {
            System.out.println(this.dungeon.getCurrentRoom());
            Room currentRoom = this.dungeon.getMap().get(this.dungeon.getCurrentRoom() - 1);
            if (currentRoom.monster == null) {
                System.out.println("No monster is present!");
                System.out.println("You are at room " + currentRoom.id);
                System.out.println("Your hero's stats are: attack " + this.hero.getAttack() + " defense "
                        + this.hero.getDefense() + " hp " + this.hero.getHp());
                System.out.println("Your level is " + this.hero.getLevel());
                this.waitUserMove = true;
            } else {
                System.out.println("There is a " + currentRoom.monster + "here. What do you want to do?");
                System.out.println("1. Fight!\n2. Run away!");
                while (getUserInput)
                    switch (InputUtility.getUserInput()) {
                        case "1":
                            if (battle.fight(this.hero, currentRoom.monster)) {
                                System.out.println("You won!");
                                levelUpCheck(this.hero, currentRoom.monster);
                                checkEquipDrop(this.hero, currentRoom.monster.getLevel());
                                currentRoom.monster = null;
                            } else {
                                System.out.println("You just got killed!");
                                this.mapCleared = true;
                            }
                            getUserInput = false;
                            break;
                        case "2":
                            if (!runAway()) {
                                if (battle.fight(this.hero, currentRoom.monster)) {
                                    System.out.println("You won!");
                                    levelUpCheck(this.hero, currentRoom.monster);
                                    checkEquipDrop(this.hero, currentRoom.monster.getLevel());
                                    currentRoom.monster = null;
                                } else {
                                    System.out.println("You just got killed!");
                                    this.mapCleared = true;
                                }
                            } else {
                                System.out.println("You managed to run away from the monster! Going back to the previous room");
                                dungeon.setCurrentRoom(dungeon.getPreviousRoom());
                            }
                            getUserInput = false;
                            break;
                        default:
                            System.out.println("Please pick a valid option. 1 or 2!");
                            break;

                    }
                System.out.println("You are at room " + currentRoom.id);
                this.waitUserMove = true;
            }
        }

    }

    public boolean runAway() {
        return (new Random().nextInt(2) == 1);
    }

    public void levelUpCheck(Hero hero, Monster monster) {
        int xp = monster.getLevel() * 300;
        hero.setXp(hero.getXp() + 300);
        if (hero.levelCheck()) {
            System.out.println("You just leveled up! Well done.");
        }

    }

    public void checkEquipDrop(Hero hero, int monsterLevel) {
        int drop = new Random().nextInt(2);
        if (drop == 1) {
            checkPlayerWantsEquip(artefactFactory.generateArtefact(monsterLevel));
        }

    }

    public void checkEquipDropGui(Hero hero, int monsterLevel) {
        int drop = new Random().nextInt(2);
        if (drop == 1) {
            checkPlayerWantsEquipGui(hero, artefactFactory.generateArtefact(monsterLevel));
        }

    }

    public void checkPlayerWantsEquipGui(Hero hero, Artefact artefact) {
        Object[] options = {"Equip","Discard"};
            int n = JOptionPane.showOptionDialog(null,
            "The monster dropped a " + artefact.getType()
            + ". Do you want to wear it? If an artefact already exists in that slot, it will be replaced",
                        "A powerful artefact",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        options,
                        options[1]);  

                        if(n == 0) {
                            artefact.equip(hero);
                            this.hero.setStats();
                        }
            }


        public void checkPlayerWantsEquip(Artefact artefact) {
            boolean waitforInput = true;
            System.out.println("The monster dropped a " + artefact.getType()
                    + ". Do you want to wear it? If an artefact already exists in that slot, it will be replaced");
            System.out.println("1. Yes\n2. No");
            while (waitforInput) {
                switch (InputUtility.getUserInput()) {
                    case "1":
                        artefact.equip(this.hero);
                        waitforInput = false;
                        this.hero.setStats();
                        System.out.println("You have now equiped a" + artefact.getType() + ".");
                        break;
                    case "2":
                        System.out.println("Fine! Consider it destroyed and forgotten");
                        waitforInput = false;
                        break;
                    default:
                        System.out.println("Please select a valid option");
                        break;
                }
    
            }

    }

}
