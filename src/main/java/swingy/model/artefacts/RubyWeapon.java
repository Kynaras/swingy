package swingy.model.artefacts;

import swingy.model.Hero;

public class RubyWeapon extends Artefact {
    private static final long serialVersionUID = 1L;

    public RubyWeapon() {
        this.stat = 15;
        this.type = "Ruby Weapon";
    }
    
    @Override
    public void equip(Hero hero) {
       hero.setWeapon(this);
    }
}
