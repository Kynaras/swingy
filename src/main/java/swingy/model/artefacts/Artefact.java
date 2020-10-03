package swingy.model.artefacts;

import java.io.Serializable;

import swingy.model.Hero;

public class Artefact implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected int stat;
    protected String type;

    public Artefact() {
        //TODO
    }

    public int getStat() {
        return stat;
    }

    public String getType() {
        return type;
    }

    public void equip(Hero hero) {
        //Add individual override
    }
}
