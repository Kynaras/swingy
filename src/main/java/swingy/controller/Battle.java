package swingy.controller;

import swingy.model.Hero;
import swingy.model.Monster;

public class Battle {

    public Battle() {

    }

    public boolean fight(Hero hero, Monster monster) {
        int heroHp = hero.getHp();
        int monsterHp = monster.getHp();

        while (heroHp > 0 && monsterHp > 0) {
            monsterHp -= (2 + hero.getAttack() - monster.getDefense());
            heroHp -= (2 + monster.getAttack()- hero.getDefense());
        }
        return heroHp > 0 ? true : false;
    }
}
