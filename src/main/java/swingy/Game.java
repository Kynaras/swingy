package swingy;

import java.lang.System.Logger.Level;
import swingy.controller.Launcher;
import swingy.controller.GUI.GuiLauncher;
import swingy.model.Hero;
import swingy.model.SaveSystem;
import swingy.model.WizardHero;

public class Game {
    public static void main(String[] args) throws Exception {
        // Launcher launcher = new Launcher();
        // launcher.start();
        GuiLauncher launcher = new GuiLauncher();
        launcher.start();
     
    }
    
}
