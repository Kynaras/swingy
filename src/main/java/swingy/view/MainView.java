package swingy.view;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;

import swingy.controller.GUI.GuiLauncher;
import swingy.model.Hero;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
    private JFrame window = new JFrame();
    private Menu menu = new Menu();
    private Map map = new Map();
    private MainMenuView mainMenu = new MainMenuView(this);
    private User user = new User();
    private GuiLauncher launcher;

    public MainView(GuiLauncher launcher) {
        this.launcher = launcher;
    }
   
    public void setUp() {
        window.setLayout(new GridLayout());
        menu.setUp(window);
        map.setUp(window, this);
        window.add(mainMenu.getCards());
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        window.pack();
        window.setVisible(true);

    }
    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public GuiLauncher getLauncher() {
        return launcher;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public MainMenuView getMainMenu() {
        return mainMenu;
    }

}
