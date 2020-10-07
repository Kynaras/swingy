package swingy;

import swingy.controller.Launcher;
import swingy.controller.GUI.GuiLauncher;

public class Game {
    public static void main(String[] args) throws Exception {
        if(args.length > 0) {
            if (args[0].equalsIgnoreCase("cli")) {
                Launcher launcher = new Launcher();
                launcher.start();
            } else if (args[0].equalsIgnoreCase("gui")) {
                GuiLauncher launcher = new GuiLauncher();
                launcher.start();
            }
        }
     
    }
    
}
