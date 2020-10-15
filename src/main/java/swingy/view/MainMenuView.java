package swingy.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import swingy.model.Hero;
import swingy.model.RogueHero;
import swingy.model.SaveSystem;
import swingy.model.WarriorHero;
import swingy.model.WizardHero;
import swingy.utilities.GroupButtonUtils;
import swingy.utilities.ValidatorUtility;

public class MainMenuView {

    JPanel cards;
    JButton buttonNewGame, buttonLoadGame, buttonSubmit, saveButton, backButton, loadingbackButton;
    JLabel loadText;
    ButtonGroup classes = new ButtonGroup();
    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Classes");
    JPanel loadCard;
    JTextField heroName;
    MainView mainView;

    public MainMenuView(MainView mainView) {
        this.mainView = mainView;
        // Menu
        buttonNewGame = new JButton("New Game");
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNewGame) {
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Character Card");
                }
            }
        });
        buttonLoadGame = new JButton("Load Game");
        buttonLoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = (CardLayout) cards.getLayout();
                prepLoadMenu();
                cardLayout.show(cards, "Load Card");

            }
        });
        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNewGame) {
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Character Card");
                }
            }
        });

        // buttonLoadGame.addActionListener(this);

        // Character creation
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
                switch (GroupButtonUtils.getSelectedButtonText(classes)) {
                    case "Wizard":
                        mainView.getLauncher().setHero(new WizardHero());
                        break;
                    case "Rogue":
                        mainView.getLauncher().setHero(new RogueHero());
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
                    mainView.getMenu().displayHero( mainView.getLauncher().getHero());
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Save Card");
                }

            }
        });

        saveButton = new JButton("Save Game");
        backButton = new JButton("Quit");
        loadingbackButton = (createBackButton());
        loadText = new JLabel("There are no saved heroes");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getLauncher().setHero(null);
                mainView.getLauncher().setHeroAlive(false);
                mainView.getMap().clearMap();
                mainView.getMenu().clearHeroMenu();
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Game Menu");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveSystem().saveHero(mainView.getLauncher().getHero());
                JOptionPane.showMessageDialog(mainView.getWindow(),
                        "Your hero has been saved! You can load the hero at the start menu next time you play.");
            }
        });

        // Create the cards

        JPanel menuCard = new JPanel();
        menuCard.add(buttonNewGame);
        menuCard.add(buttonLoadGame);

        JPanel characterCard = new JPanel();
        characterCard.add(heroName);
        characterCard.add(wizardButton);
        characterCard.add(warriorButton);
        characterCard.add(rogueButton);
        characterCard.add(buttonSubmit, "wrap");
        characterCard.add(backButton);
        characterCard.add(new JLabel("Tip: Wizards = easymode. Rogues can crit easily. Warrior just suck."), "wrap");

        JPanel saveCard = new JPanel();
        saveCard.add(saveButton, "wrap");
        saveCard.add(createBackButton());


        loadCard = new JPanel();

        // Create the panel that contains the "cards".

        cards = new JPanel(new CardLayout());

        cards.add(menuCard, "Game Menu");
        cards.add(characterCard, "Character Card");
        cards.add(saveCard, "Save Card");
        cards.add(loadCard, "Load Card");
        cards.setSize(300, 300);

    }

    public void prepLoadMenu(){
    SaveSystem loader = new SaveSystem();
    String[] fileNames = loader.listFiles();
    JButton lButton;
    loadCard.removeAll();

      if (fileNames.length == 0) {
         loadCard.add(loadText, "wrap");
         loadCard.add(loadingbackButton, "wrap");
         return;
      }
      loadCard.setLayout(new MigLayout());
      loadCard.add(new JLabel("Please select one of the heroes."), "wrap");
      for (int i = 0; i < fileNames.length; i++) {
          Hero hero = loader.loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/" + fileNames[i]);
        lButton = new JButton(hero.getName() + " - " + hero.getProfession());
        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getLauncher().setHero(hero);
                mainView.getLauncher().setHeroAlive(true);
                mainView.getLauncher().mapGen();
                mainView.getMenu().displayHero(mainView.getLauncher().getHero());
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "Save Card");
            }
        });
        loadCard.add(lButton, "wrap");
      }
      loadCard.add(createBackButton());
      loadCard.revalidate();
      loadCard.repaint();
    }

    public void resetMenu() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "Game Menu");
    }

    public JPanel getCards() {
        return cards;
    }

    private JButton createBackButton () {
        backButton = new JButton("Quit");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getLauncher().setHero(null);
                mainView.getLauncher().setHeroAlive(false);
                mainView.getMap().clearMap();
                mainView.getMenu().clearHeroMenu();
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Game Menu");
            }
        });

        return backButton;
    }
}
