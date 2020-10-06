package swingy.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import swingy.model.Hero;
import swingy.model.RogueHero;
import swingy.model.SaveSystem;
import swingy.model.WarriorHero;
import swingy.model.WizardHero;
import swingy.utilities.GroupButtonUtils;
import swingy.utilities.ValidatorUtility;

public class MainMenuView {

    JPanel cards;
    JButton buttonNewGame, buttonLoadGame, buttonSubmit, saveButton;
    ButtonGroup classes = new ButtonGroup();
    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Classes");
    JTextField heroName;
    MainView mainView;
    

    public MainMenuView(MainView mainView) {
        this.mainView = mainView;
        //Menu
        buttonNewGame = new JButton("New Game");
        buttonLoadGame = new JButton("Load Game");
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNewGame) {
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Character Card");
                }
        }});

        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNewGame) {
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Character Card");
                }
        }});

        // buttonLoadGame.addActionListener(this);

        //Character creation
        heroName = new JTextField("Enter your hero name here");
        JRadioButtonMenuItem wizardButton = new JRadioButtonMenuItem("Wizard");
        wizardButton.setSelected(true);
        classes.add(wizardButton);
        JRadioButtonMenuItem rogueButton = new JRadioButtonMenuItem("Rogue");
        classes.add(rogueButton);
        JRadioButtonMenuItem warriorButton = new JRadioButtonMenuItem("Warrior");
        classes.add(warriorButton);
      
        buttonSubmit = new JButton("Create Hero");

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(GroupButtonUtils.getSelectedButtonText(classes)){
                    case "Wizard": 
                    mainView.getLauncher().setHero(new WizardHero());
                    break;
                    case "Rogue":
                    mainView.getLauncher().setHero(new RogueHero());
                    System.out.println("Got here");
                    break;
                    case "Warrior":
                    mainView.getLauncher().setHero(new WarriorHero());
                    break;
                    default:
                    break;
                }
                mainView.getLauncher().getHero().setName(heroName.getText());
                if (!ValidatorUtility.checkValidity(mainView.getLauncher().getHero())) {
                    JOptionPane.showMessageDialog(mainView.getWindow(), "Please enter a valid name!");
                } else {
                    mainView.getLauncher().setHeroAlive(true);
                    mainView.getLauncher().mapGen();
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Save Card");
                }
               
        }});

       saveButton = new JButton("Save Game");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveSystem().saveHero(mainView.getLauncher().getHero());
                JOptionPane.showMessageDialog(mainView.getWindow(), "Your hero has been saved! You can load the hero at the start menu next time you play.");
        }});

        

        // Create the cards

        JPanel menuCard = new JPanel();
        menuCard.add(buttonNewGame);
        menuCard.add(buttonLoadGame);

        JPanel characterCard = new JPanel();
        characterCard.add(heroName);
        characterCard.add(wizardButton);
        characterCard.add(warriorButton);
        characterCard.add(rogueButton);
        characterCard.add(buttonSubmit);

        JPanel saveCard = new JPanel();
        saveCard.add(saveButton);
        



        // Create the panel that contains the "cards".

        cards = new JPanel(new CardLayout());

        cards.add(menuCard, "Game Menu");
        cards.add(characterCard, "Character Card");
        cards.add(saveCard, "Save Card");
      
    }

    public void resetMenu() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Game Menu");
    }

    public JPanel getCards() {
        return cards;
    }
}
