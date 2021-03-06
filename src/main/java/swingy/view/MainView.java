package swingy.view;

import javax.swing.JFrame;

import swingy.controller.GUI.GuiLauncher;

import java.awt.GridLayout;


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
        window.setSize(1200, 1200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
