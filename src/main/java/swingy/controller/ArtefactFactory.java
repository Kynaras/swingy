package swingy.controller;

import java.util.Random;

import swingy.model.artefacts.Artefact;
import swingy.model.artefacts.RubyArmour;
import swingy.model.artefacts.RubyHelm;
import swingy.model.artefacts.RubyWeapon;
import swingy.model.artefacts.SteelArmour;
import swingy.model.artefacts.SteelHelm;
import swingy.model.artefacts.SteelWeapon;
import swingy.model.artefacts.WoodenArmour;
import swingy.model.artefacts.WoodenHelm;
import swingy.model.artefacts.WoodenWeapon;

public class ArtefactFactory {
    Random random = new Random();
    ArtefactFactory () {
        //Todo
    }

    public Artefact generateArtefact(int artefactLevel) {
            switch (artefactLevel) {
                case 1:
                return generateWoodenArtefact();
                case 2:
                return generateSteelArtefact();
                case 3: 
                return generateRubyArtefact();
                default:
                return generateSteelArtefact();
        }
    }

    public Artefact generateWoodenArtefact() {
        int type = random.nextInt(3);
        switch (type) {
            case 1:
            return new WoodenHelm();
            case 2:
            return new WoodenArmour();
            default:
            return new WoodenWeapon();
        }
    }

    public Artefact generateSteelArtefact() {
        int type = random.nextInt(3);
        switch (type) {
            case 1:
            return new SteelHelm();
            case 2:
            return new SteelArmour();
            default:
            return new SteelWeapon();
        }
    }

    public Artefact generateRubyArtefact() {
        int type = random.nextInt(3);
        switch (type) {
            case 1:
            return new RubyHelm();
            case 2:
            return new RubyArmour();
            default:
            return new RubyWeapon();
        }
    }
}
