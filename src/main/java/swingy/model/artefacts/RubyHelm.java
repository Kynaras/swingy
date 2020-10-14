package swingy.model.artefacts;

import swingy.model.Hero;

public class RubyHelm extends Artefact {
    private static final long serialVersionUID = 1L;

    public RubyHelm() {
        this.stat = 15;
        this.type = "Ruby Helm";
    }
    @Override
    public void equip(Hero hero) {
       hero.setHelm(this);
    }
    
}
