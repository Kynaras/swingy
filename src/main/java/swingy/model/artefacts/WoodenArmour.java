package swingy.model.artefacts;
import swingy.model.Hero;

public class WoodenArmour extends Artefact {

    private static final long serialVersionUID = 1L;
    public WoodenArmour() {
        this.stat = 5;
        this.type = "Wooden Armour";
    }

    @Override
    public void equip(Hero hero) {
       hero.setArmour(this);
    }
}
