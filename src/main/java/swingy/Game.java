package swingy;

import swingy.controller.Launcher;
import swingy.controller.GUI.GuiLauncher;
import java.awt.*;
public class Game {
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(new Runnable () {
            @Override
            public void run() {
              
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
        });
        }
    
}
