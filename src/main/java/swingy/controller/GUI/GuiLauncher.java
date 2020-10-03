package swingy.controller.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import swingy.view.MainView;

public class GuiLauncher {

    private MainView mainView = new MainView();

    public GuiLauncher () {
        //TODO
    }
    public void start() {
        mainView.setUp();
    }
    
}
