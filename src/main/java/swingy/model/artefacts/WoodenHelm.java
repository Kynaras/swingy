package swingy.model.artefacts;

import swingy.model.Hero;

public class WoodenHelm extends Artefact {
    public WoodenHelm() {
        this.stat = 5;
        this.type = "Wooden Helm";
    }

    @Override
    public void equip(Hero hero) {
       hero.setHelm(this);
    }
}
