package swingy.model;

public class RogueHero extends Hero  {
    private static final long serialVersionUID = 1L;
    public RogueHero() {
        super();
        this.profession = "rogue";
        this.baseHp = 20;
        this.baseDefense = 18;
        this.baseAttack = 25;
        setStats();
    }
    
}
