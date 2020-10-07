package swingy.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import swingy.model.Hero;

import java.awt.*;
import javax.swing.JFrame;  
import java.awt.*;  
import java.awt.event.*;  

public class Menu {

    private JPanel menuPanel;

    public void setUp(JFrame window) {          
        this.menuPanel = new JPanel(new MigLayout());

      

        // menuPanel.add(title, "span");
        // menuPanel.add(newGame, "span");
        // menuPanel.add(loadGame, "span");
        menuPanel.setSize(400, 400);
        window.add(menuPanel);
        // window.setSize(400, 400);
        // window.setVisible(true);
    }

    public void displayHero(Hero hero) {
        System.out.println("Updataing hero info...");
        menuPanel.removeAll();

        JLabel name = new JLabel("Hero name: " + hero.getName());
        JLabel level = new JLabel("Level: " + Integer.toString(hero.getLevel()));
        JLabel hp = new JLabel("HP: " +Integer.toString(hero.getHp()));
        JLabel attack = new JLabel("Attack: " +Integer.toString(hero.getAttack()));
        JLabel defense = new JLabel("Defense: " +Integer.toString(hero.getDefense()));

        menuPanel.add(name, "wrap");
        menuPanel.add(attack, "wrap");
        menuPanel.add(defense, "wrap");
        menuPanel.add(hp, "wrap");
        menuPanel.add(level, "wrap");
        
        menuPanel.revalidate();
        menuPanel.repaint();
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public void clearHeroMenu() {
        if (this.menuPanel != null) {
            menuPanel.removeAll();
            menuPanel.revalidate();
            menuPanel.repaint();
        }
    }
}
