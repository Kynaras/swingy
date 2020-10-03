package swingy.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Map {

    public void setUp(JFrame window) {        
        JPanel mapPanel = new JPanel(new MigLayout());
        mapPanel.setSize(400, 400);
        window.add(mapPanel);
    }
    
}
