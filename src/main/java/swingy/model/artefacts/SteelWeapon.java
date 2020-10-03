package swingy.model.artefacts;

import swingy.model.Hero;

public class SteelWeapon extends Artefact {

    private static final long serialVersionUID = 1L;
    public SteelWeapon() {
        this.stat = 10;
        this.type = "Steel Weapon";
    }

     @Override
    public void equip(Hero hero) {
       hero.setWeapon(this);
    }
}
