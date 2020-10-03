package swingy.controller;

import swingy.model.Hero;
import swingy.model.RogueHero;
import swingy.model.WarriorHero;
import swingy.model.WizardHero;
import swingy.utilities.InputUtility;
import swingy.utilities.ValidatorUtility;

public class CreateHero {
    private Hero hero;

    public Hero newHero(){
            chooseProfession();
            chooseName();
            return this.hero;
    }

    private void chooseProfession(){
        boolean professionChosen = false;
        while (!professionChosen) {
            System.out.println("Okay. let's begin! Please pick your profession. Your choices are:\n1. Wizard \n2. Rogue\n3. Warrior");
            switch(InputUtility.getUserInput().trim().toLowerCase()){
                case "1": 
                this.hero = new WizardHero();
                professionChosen = true;
                break;
                case "2":
                this.hero = new RogueHero();
                professionChosen = true;
                break;
                case "3":
                this.hero = new WarriorHero();
                professionChosen = true;
                break;
                default:
                System.out.println("You need to choose one of the three acceptable professions. Any other option is invalid");
                break;
            }
        }
    }

    private void chooseName(){
        boolean nameChosen = false;
        String input;

        while (!nameChosen) {
            System.out.println("What is your name, " + this.hero.getProfession() +"?");
            input = InputUtility.getUserInput().trim();
            this.hero.setName(input);
            if (ValidatorUtility.checkFieldValidty(this.hero, "name")) {
                nameChosen = true;
            }

        }

    }
}
