package swingy.model.artefacts;

import swingy.model.Hero;

public class SteelHelm extends Artefact {

    private static final long serialVersionUID = 1L;

    public SteelHelm() {
        this.stat = 10;
        this.type = "Steel Helm";
    }


    @Override
    public void equip(Hero hero) {
       hero.setHelm(this);
    }
}
