package swingy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Monster {
    @NotNull
    String type;
    @Min(1)
    int hp;
    @Min(1)
    int defense;
    @Min(1)
    int attack;
    @Min(1)
    int level;

    public Monster ()
 {
     //todo
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

 public int getLevel() {
     return level;
 }
}
