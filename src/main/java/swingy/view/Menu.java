package swingy.view;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import swingy.model.Hero;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class Menu {

    private JPanel menuPanel;
    BufferedImage myPicture;

    public void setUp(JFrame window) {
        this.menuPanel = new JPanel(new MigLayout());

        menuPanel.setSize(300, 300);
        window.add(menuPanel);
    }

    public void displayHero(Hero hero) {
        hero.setStats();
        String file = System.getProperty("user.dir");
        switch (hero.getProfession()) {
            case "rogue":
                file = file + "/src/main/java/swingy/images/rogue.jpg";
                break;
            case "wizard":
                file = file + "/src/main/java/swingy/images/wizard.jpg";
                break;
            case "warrior":
                file = file + "/src/main/java/swingy/images/warrior.jpg";
                break;
            default:
                file = file = "/src/main/java/swingy/images/rogue.jpg";
                break;
        }
        try {
            myPicture = ImageIO.read(new File(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {  
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                menuPanel.removeAll();
                menuPanel.add(picLabel, "wrap");
                JLabel name = new JLabel("Hero name: " + hero.getName());
                JLabel level = new JLabel("Level: " + Integer.toString(hero.getLevel()));
                JLabel hp = new JLabel("HP: " + Integer.toString(hero.getHp()));
                JLabel attack = new JLabel("Attack: " + Integer.toString(hero.getAttack()));
                JLabel defense = new JLabel("Defense: " + Integer.toString(hero.getDefense()));

                menuPanel.add(name, "wrap");
                menuPanel.add(attack, "wrap");
                menuPanel.add(defense, "wrap");
                menuPanel.add(hp, "wrap");
                menuPanel.add(level, "wrap");

                menuPanel.revalidate();
                menuPanel.repaint();
            }
        });
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
