package swingy.controller;

import swingy.model.Hero;
import swingy.model.RogueHero;
import swingy.model.WarriorHero;
import swingy.model.WizardHero;

public class HeroFactory {

    public Hero newHero(String profession, String name) {
        switch(profession) {
            case "wizard":
            return new WizardHero();
            case "warrior":
            return new RogueHero();
            case "rogue":
            return new WarriorHero();
            default:
                return null;
            
        }
    }
    
}
