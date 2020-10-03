package swingy.view;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
    private JFrame window = new JFrame();
    private Menu menu = new Menu();
    private Map map = new Map();
    private User user = new User();

    public void setUp() {
        window.setLayout(new GridLayout());
        menu.setUp(window);
        map.setUp(window);
        window.setSize(800, 800);
        window.pack();
        window.setVisible(true);

    }
    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
}
