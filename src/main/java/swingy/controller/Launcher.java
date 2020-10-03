package swingy.controller;

import swingy.utilities.InputUtility;
import swingy.utilities.SystemMessages;
import swingy.utilities.ValidatorUtility;
import swingy.model.Dungeon;
import swingy.model.Hero;
import swingy.model.Room;
import swingy.model.SaveSystem;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class Launcher {
   Boolean getUserInput = true;
   private String userInput;
   private Hero hero;
   private CreateMap createMap = new CreateMap();

   public Launcher() {
      // To do
   }

   public void start() {
      System.out.println(SystemMessages.START_MENU_MESSAGE);

      while (this.getUserInput) {
         switch (InputUtility.getUserInput().trim()) {
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
               System.out.println("You need to choose either option 1 or 2. Any other option is invalid");
               break;
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
         System.out.println("There are currently no saved heroes. You will have to start a new game!");
         return;
      }
      System.out.println("Please select one of the heroes.");
      for (int i = 0; i < fileNames.length; i++) {
         System.out.println((i + 1) + ". " + loader
               .loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/" + fileNames[i]).getName());
      }

      while (getUserInput) {
         String input = InputUtility.getUserInput();
         if (input.matches("[0-9]+") && (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= fileNames.length)) {
            this.hero = loader.loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/"
                  + fileNames[Integer.parseInt(input) - 1]);
            System.out.println(this.hero.getName() + " is ready for adventure!");
            getUserInput = false;
         } else {
            System.out.println("Incorrect option. Please enter a number related to a valid save file");
         }

      }
   }
}
