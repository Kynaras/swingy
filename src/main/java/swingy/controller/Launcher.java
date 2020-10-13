package swingy.controller;

import swingy.utilities.InputUtility;
import swingy.utilities.SystemMessages;
import swingy.utilities.ValidatorUtility;
import swingy.view.Cli;
import swingy.model.Dungeon;
import swingy.model.Hero;
import swingy.model.Room;
import swingy.model.SaveSystem;
import swingy.model.UserInputs;

public class Launcher {
   Boolean getUserInput = true;
   private String userInput;
   private Hero hero;
   private CreateMap createMap = new CreateMap();
   private UserInputs inputValidation = new UserInputs();

   public Launcher() {
      // To do
   }

   public void start() {

      Cli.display(Cli.START_MENU_MESSAGE);

      while (Boolean.TRUE.equals(this.getUserInput)) {
         inputValidation.setGameMenuInput(InputUtility.getUserInput().trim());
         if (!ValidatorUtility.checkFieldValidty(inputValidation, "gameMenuInput")) {
            Cli.display(Cli.START_MENU_ERROR_MESSAGE);
         } else {
            switch (inputValidation.getGameMenuInput()) {
               case "1":
                  newHero();
                  startGame();
                  getUserInput = false;
                  break;
               case "2":
                  loadGameMenu();
                  getUserInput = false;
                  startGame();
                  break;
               default:
                  Cli.display(Cli.START_MENU_ERROR_MESSAGE);
                  break;
            }
         }
      }

   }

   public void newHero() {
      CreateHero createHero = new CreateHero();
      this.hero = createHero.newHero();
   }

   public void startGame() {
      CreateMap mapper = new CreateMap();
      Dungeon dungeon = new Dungeon(mapper.setup(this.hero.getLevel()), InputUtility.getMapsize(this.hero.getLevel()));
      Game game = new Game(dungeon, this.hero);
      game.startGame();

   }

   public void loadGameMenu() {
      SaveSystem loader = new SaveSystem();
      String[] fileNames = loader.listFiles();
      boolean getUserInput = true;

      if (fileNames.length == 0) {
         Cli.display(Cli.NO_SAVE_FILE);
         return;
      }
      System.out.println("Please select one of the heroes.");
      for (int i = 0; i < fileNames.length; i++) {
         System.out.println((i + 1) + ". " + loader
               .loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/" + fileNames[i]).getName());
      }

      while (getUserInput) {
         inputValidation.setLoadMenuInput(InputUtility.getUserInput().trim());
         if (ValidatorUtility.checkFieldValidty(inputValidation, "loadMenuInput")) {
            if ((Integer.parseInt(inputValidation.getLoadMenuInput()) > 0
                  && Integer.parseInt(inputValidation.getLoadMenuInput()) <= fileNames.length)) {
               this.hero = loader.loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/"
                     + fileNames[Integer.parseInt(inputValidation.getLoadMenuInput()) - 1]);
               System.out.println(this.hero.getName() + " is ready for adventure!");
               getUserInput = false;
            } else {
               System.out.println("Incorrect option. Please enter a number related to a valid save file");
            }
         } else {
            System.out.println("Incorrect option. Please enter a number related to a valid save file");
         }

      }
   }
}
