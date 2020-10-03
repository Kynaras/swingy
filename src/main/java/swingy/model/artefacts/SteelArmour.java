package swingy.model.artefacts;

import swingy.model.Hero;

public class SteelArmour extends Artefact {

     /**
   *
   */
   private static final long serialVersionUID = 1L;

   public SteelArmour() {
        this.stat = 10;
        this.type = "Steel Armour";
    }

    @Override
    public void equip(Hero hero) {
       hero.setArmour(this);
    }
}
