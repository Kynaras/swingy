package swingy.model.artefacts;

import swingy.model.Hero;

public class RubyArmour extends Artefact {
    private static final long serialVersionUID = 1L;

    public RubyArmour() {
        this.stat = 15;
        this.type = "Ruby Armour";
    }
    @Override
    public void equip(Hero hero) {
       hero.setHelm(this);
    }
}
