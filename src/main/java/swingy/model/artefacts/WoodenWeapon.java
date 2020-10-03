package swingy.model.artefacts;

import swingy.model.Hero;

public class WoodenWeapon extends Artefact {

    public WoodenWeapon() {
        this.stat = 5;
        this.type = "Wooden Weapon";
    }

    @Override
    public void equip(Hero hero) {
       hero.setWeapon(this);
    }
}
