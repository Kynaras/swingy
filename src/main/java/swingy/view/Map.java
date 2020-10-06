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
import swingy.controller.Battle;
import swingy.controller.Game;
import swingy.controller.GUI.GuiLauncher;
import swingy.model.Dungeon;
import swingy.model.Room;

public class Map {
    private JPanel mapPanel;
    private Dungeon dungeon;
    private MainView mainview;
    private Game game = null;

    public void setUp(JFrame window, MainView mainview) {
        this.mainview = mainview;
        this.mapPanel = new JPanel();
        mapPanel.setSize(400, 400);
        JScrollPane scrollableTextArea = new JScrollPane(mapPanel);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(scrollableTextArea);
    }

    private void setKeyListeners(Dungeon dungeon) {
        this.mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
        this.mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
        this.mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        this.mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        this.mapPanel.getActionMap().put("up", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Boolean.FALSE.equals(mainview.getLauncher().getHeroAlive())) {
                    return;
                }
                if (dungeon.getCurrentRoom() == null) {
                    JOptionPane.showMessageDialog(mapPanel, "You have finished the dungeon!");
                    mainview.getLauncher().mapGen();
                    return;
                }
                dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).north);
                prepMap(dungeon);
            }
        });
        this.mapPanel.getActionMap().put("left", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Boolean.FALSE.equals(mainview.getLauncher().getHeroAlive())) {
                    return;
                }
                if (dungeon.getCurrentRoom() == null) {
                    JOptionPane.showMessageDialog(mapPanel, "You have finished the dungeon!");
                    mainview.getLauncher().mapGen();
                    return;
                }
                dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).west);
                prepMap(dungeon);
            }
        });
        this.mapPanel.getActionMap().put("down", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Boolean.FALSE.equals(mainview.getLauncher().getHeroAlive())) {
                    return;
                }
                if (dungeon.getCurrentRoom() == null) {
                    JOptionPane.showMessageDialog(mapPanel, "You have finished the dungeon!");
                    mainview.getLauncher().mapGen();
                    return;
                }
                dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).south);
                prepMap(dungeon);
            }
        });
        this.mapPanel.getActionMap().put("right", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Boolean.FALSE.equals(mainview.getLauncher().getHeroAlive())) {
                    return;
                }
                if (dungeon.getCurrentRoom() == null) {
                    JOptionPane.showMessageDialog(mapPanel, "You have finished the dungeon!");
                    mainview.getLauncher().mapGen();
                    return;
                }
                dungeon.setPreviousRoom(dungeon.getCurrentRoom());
                dungeon.setCurrentRoom(dungeon.getMap().get(dungeon.getCurrentRoom() - 1).east);
                prepMap(dungeon);
            }
        });

    }

    public void clearMap() {
        dungeon = null;
        System.out.println("fired!");
        mapPanel.removeAll();
        mapPanel.revalidate();
        mapPanel.repaint();
    }

    public void prepMap(Dungeon dungeon) {
        if (Boolean.FALSE.equals(mainview.getLauncher().getHeroAlive())) {
            return;
        }
        Room currentRoomMonster;
        if (dungeon.getCurrentRoom() == null) {
            JOptionPane.showMessageDialog(mapPanel, "You have finished the dungeon!");
            mainview.getLauncher().mapGen();
            return;
        } else {
            currentRoomMonster = dungeon.getMap().get(dungeon.getCurrentRoom() - 1);
            if (currentRoomMonster.monster != null) {
                if (this.game == null) {
                    this.game = new Game(this.dungeon, mainview.getLauncher().getHero());
                }
                Object[] options = { "Fight!", "Run!" };
                int n = JOptionPane.showOptionDialog(null,
                        "A " + currentRoomMonster.monster.getType() + " has appeared. What will you do?",
                        "An encounter", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, options,
                        options[1]);
                if (n == 0) {
                    if (new Battle().fight(mainview.getLauncher().getHero(), currentRoomMonster.monster)) {
                        game.levelUpCheck(mainview.getLauncher().getHero(), currentRoomMonster.monster);
                        game.checkEquipDropGui(mainview.getLauncher().getHero(), currentRoomMonster.monster.getLevel());
                        currentRoomMonster.monster = null;
                        JOptionPane.showMessageDialog(mapPanel,
                                "The monster has been defeated. You are free to carry on exploring");
                    } else {
                        JOptionPane.showMessageDialog(mapPanel, "You died!");
                        mapPanel.removeAll();
                        mainview.getLauncher().heroDied();
                        return;
                    }
                } else {
                    if (!game.runAway()) {
                        if (new Battle().fight(mainview.getLauncher().getHero(), currentRoomMonster.monster)) {
                            game.levelUpCheck(mainview.getLauncher().getHero(), currentRoomMonster.monster);
                            game.checkEquipDropGui(mainview.getLauncher().getHero(),
                                    currentRoomMonster.monster.getLevel());
                            currentRoomMonster.monster = null;
                            JOptionPane.showMessageDialog(mapPanel,
                                    "The monster has been defeated. You are free to carry on exploring");
                        } else {
                            JOptionPane.showMessageDialog(mapPanel, "You died!");
                            mapPanel.removeAll();
                            mainview.getLauncher().heroDied();
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(mapPanel,
                                "You manage to run away before the monster notices you.");
                        dungeon.setCurrentRoom(dungeon.getPreviousRoom());
                    }
                }

            }
            this.dungeon = dungeon;
            mapPanel.removeAll();
            setKeyListeners(this.dungeon);
            Integer currentRoom = dungeon.getCurrentRoom();
            mapPanel.setLayout(new MigLayout("wrap " + dungeon.getDimensions()));
            if (dungeon != null) {
                JButton button;
                mapPanel.removeAll();
                for (Iterator<Room> iter = dungeon.getMap().iterator(); iter.hasNext();) {
                    Room room = iter.next();
                    mapPanel.add(button = new JButton(Integer.toString(room.id)));
                    if (currentRoom.equals(room.id)) {
                        button.setBackground(Color.PINK);
                    }
                    button.setFocusable(false);
                }
                mapPanel.revalidate();
                mapPanel.repaint();

            }
        }

    }
}
