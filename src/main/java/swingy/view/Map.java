package swingy.view;

import java.awt.Color;
import java.util.Iterator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import swingy.model.Dungeon;
import swingy.model.Room;

public class Map {
    private JPanel mapPanel;
    Dungeon dungeon;
    public void setUp(JFrame window) {        
        this.mapPanel = new JPanel();
        mapPanel.setSize(400, 400);
        JScrollPane scrollableTextArea = new JScrollPane(mapPanel);  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        window.add(scrollableTextArea);
    }

    public void prepMap(Dungeon dungeon) {
        this.dungeon = dungeon;
        mapPanel.removeAll();
        this.mapPanel.addKeyListener(new MapKeyListener());
        this.mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "pressed");
        this.mapPanel.getActionMap().put("pressed", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).north);
                prepMap(dungeon);
            }
        });
        int currentRoom = dungeon.getCurrentRoom();
        mapPanel.setLayout(new MigLayout("wrap " + dungeon.getDimensions()));
        if (dungeon != null) {
            JButton button;
            mapPanel.removeAll();
            for (Iterator<Room> iter =  dungeon.getMap().iterator(); iter.hasNext(); ) {
                Room room = iter.next();
                mapPanel.add(button = new JButton(Integer.toString(room.id)));
                if (room.id == currentRoom){
                    button.setBackground(Color.PINK);
                }
            }
            mapPanel.revalidate();
            mapPanel.repaint();
            
        }        
    }

    class MapKeyListener implements KeyListener{
        public void keyTyped(KeyEvent e) {
            System.out.println("You pressed northaaaa");
        }
        public void keyPressed(KeyEvent e) {
          
            dungeon.setPreviousRoom(dungeon.getCurrentRoom());
            dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).north);
            System.out.println("You pressed north");
           
        }
        public void keyReleased(KeyEvent e) {
            System.out.println("You pressed northaaaaww");
        }   
     }
    
}
