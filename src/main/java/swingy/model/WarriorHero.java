package swingy.model;

public class WarriorHero extends Hero {
    private static final long serialVersionUID = 1L;
    public WarriorHero() {
        super();
        this.profession = "warrior";
        this.baseHp = 25;
        this.baseDefense = 23;
        this.baseAttack = 20;
        setStats();
    }
    
}
