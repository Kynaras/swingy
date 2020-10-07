package swingy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import swingy.model.artefacts.Artefact;


public class Hero implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotEmpty
    protected String name;
    @NotEmpty
    protected String profession;
    @Min(1)
    protected int level;
    @Min(0)
    protected int xp;
    @Min(1)
    protected int attack;
    @Min(1)
    protected int hp;
    @Min(1)
    protected int defense;
    @Min(1)
    protected int baseAttack;
    @Min(1)
    protected int baseHp;
    @Min(1)
    protected int baseDefense;
    protected Artefact helm = null;
    protected Artefact armour = null;
    protected Artefact weapon = null;

    public Hero () {
        this.level = 1;
        this.xp = 0;
    }

    public boolean levelCheck() {
        int squaredlevel = (level - 1) * (level - 1);
        int levelUpXp = 1000+(squaredlevel)*450;
        if (this.xp >= levelUpXp) {
            this.level++;
            switch(this.profession) {
                case "wizard":
                this.baseAttack += 3;
                this.baseDefense += 3;
                break;
                case "warrior":
                this.baseAttack += 1;
                this.baseDefense += 4;
                this.baseHp += 1;
                break;
                case "rogue":
                this.baseAttack += 3;
                this.baseDefense += 2;
                this.baseHp += 1;
                break;
                default:
                this.baseHp += 2;
                this.baseAttack += 2;
                this.baseDefense += 2;
                break;
            }
            this.setStats();
            return true;
        }
        return false;
    }


    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }


    public int getXp() {
        return xp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setArmour(Artefact armour) {
        this.armour = armour;
    }

    public void setWeapon(Artefact weapon) {
        this.weapon = weapon;
    }

    public void setHelm(Artefact helm) {
        this.helm = helm;
    }

    public void setStats() {
        System.out.println("checking new stats");
        if (this.weapon != null) {
            System.out.println(this.weapon.getStat());
            this.attack = this.baseAttack + this.weapon.getStat();
        }
            else
                this.attack = this.baseAttack;
        if (this.helm != null) {
            this.hp = this.baseHp + this.helm.getStat();
        } else
                this.hp = this.baseHp;
        if (this.armour != null) {
            System.out.println(this.armour.getStat());
            this.defense = this.baseDefense + this.armour.getStat();
         } else
                this.defense = this.baseDefense;

    }
}
