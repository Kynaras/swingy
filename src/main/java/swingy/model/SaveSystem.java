package swingy.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.*;

public class SaveSystem {

   private String root = System.getProperty("user.dir") + "/src/main/java/swingy/saves/";

   public long countSaves() {
      try (Stream<Path> files = Files.list(Paths.get(root))) {
         return files.count();
     } catch(java.io.IOException e){
      System.out.println("Path getting failed:" + e);
  }
  return 0;
   }

   public String[] listFiles(){
      File directoryPath = new File(root);
      return directoryPath.list();
   }

    public void saveHero(Hero e) {
      long saveNumber = countSaves() + 1;
      System.out.println(saveNumber);
        try ( FileOutputStream fileOut = new FileOutputStream(root + "hero" + saveNumber + ".ser");) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            System.out.println("Serialized data is saved in hero"+saveNumber+".ser");
         } catch (IOException i) {
            i.printStackTrace();
         } 
    }

    public Hero loadHeroFile(String filename) {
        Hero e = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);){
            e = (Hero) in.readObject();
            return e;
         } catch (IOException i) {
            i.printStackTrace();
            return null;
         } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
         }
    } 

    public void getSaves() {
       String[] names = listFiles();
       for(int i=0; i<names.length; i++) {
         System.out.println(loadHeroFile(System.getProperty("user.dir") + "/src/main/java/swingy/saves/" + names[i]).name);
      }
    }
}
