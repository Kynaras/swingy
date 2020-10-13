package swingy.controller;

import java.util.Random;

import swingy.model.Hero;
import swingy.model.Monster;

public class Battle {
    private Random random = new Random();
    public Battle() {
        //Nothing to add
    }

    public boolean fight(Hero hero, Monster monster) {
        int heroHp = hero.getHp();
        int monsterHp = monster.getHp();

        while (heroHp > 0 && monsterHp > 0) {
            monsterHp -= (2 + hero.getAttack() - monster.getDefense());
            heroHp -= (2 + monster.getAttack()- hero.getDefense());
           if(rollDice(hero)) {
                monsterHp -= (2 + hero.getAttack() - monster.getDefense());
            }
        }
        return heroHp > 0 ? true : false;
    }

    private boolean rollDice(Hero hero) {
        int dice = 10;
        if (hero.getProfession().equals("rogue")){ 
            dice = 20;
        }
        return random.nextInt(dice) > 8 ? true : false;
    }
}
