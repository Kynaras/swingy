package swingy.model;

public class WizardHero extends Hero {
    private static final long serialVersionUID = 1L;
    public WizardHero() {
        super();
        this.profession = "wizard";
        this.baseHp = 10;
        this.baseDefense = 28;
        this.baseAttack = 28;
        setStats();
}
}
