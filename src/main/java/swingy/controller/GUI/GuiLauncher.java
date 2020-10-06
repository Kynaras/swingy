package swingy.controller.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import swingy.Game;
import swingy.Map;
import swingy.controller.CreateMap;
import swingy.model.Dungeon;
import swingy.model.Hero;
import swingy.utilities.InputUtility;
import swingy.view.MainView;
import swingy.view.MapView;

public class GuiLauncher {

    private Hero hero;
    private Dungeon dungeon;
    private MainView mainView = new MainView(this);
    private Boolean heroAlive;

    public GuiLauncher () {
        //TODO
    }

    public void mapGen() {
        CreateMap mapper = new CreateMap();
        this.dungeon = new Dungeon(mapper.setup(this.hero.getLevel()), InputUtility.getMapsize(this.hero.getLevel()));
      mainView.getMap().prepMap(this.dungeon);     
    }
    public void start() {
        mainView.setUp();
    }
    
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void showHero(){
        System.out.println(hero);
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public Boolean getHeroAlive() {
        return heroAlive;
    }

    public void setHeroAlive(Boolean heroAlive) {
        this.heroAlive = heroAlive;
    }
    

    public void heroDied() {
        this.heroAlive = false;
        this.hero = null;
        mainView.getMainMenu().resetMenu();
        mainView.getMap().clearMap();
    }
    
}
