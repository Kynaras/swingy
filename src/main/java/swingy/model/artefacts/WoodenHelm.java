package swingy.model.artefacts;

import swingy.model.Hero;

public class WoodenHelm extends Artefact {
    private static final long serialVersionUID = 1L;
    public WoodenHelm() {
        this.stat = 5;
        this.type = "Wooden Helm";
    }

    @Override
    public void equip(Hero hero) {
       hero.setHelm(this);
    }
}
