package swingy.model;

public class RogueHero extends Hero  {
    public RogueHero() {
        super();
        this.profession = "rogue";
        this.baseHp = 20;
        this.baseDefense = 19;
        this.baseAttack = 25;
        setStats();
    }
    
}
