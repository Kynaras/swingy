package swingy.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.JFrame;  
import java.awt.*;  
import java.awt.event.*;  

public class Menu {

    public void setUp(JFrame window) {
        JLabel title = new JLabel("Swingy");
        JButton north = new JButton("North");
        JButton south = new JButton("South"); 
        JButton east = new JButton("East");   
        JButton west = new JButton("West");          
        JPanel menuPanel = new JPanel(new MigLayout());

      

        // menuPanel.add(title, "span");
        // menuPanel.add(newGame, "span");
        // menuPanel.add(loadGame, "span");
        menuPanel.setSize(400, 400);
        window.add(menuPanel);
        // window.setSize(400, 400);
        // window.setVisible(true);
    }
    
}
