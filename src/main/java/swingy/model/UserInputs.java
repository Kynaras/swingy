package swingy.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInputs {
    @NotNull
    @Pattern(regexp = "1|2")
    protected String gameMenuInput;
    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String loadMenuInput;
    @NotNull
    @Pattern(regexp = "1|2")
    private String saveGameOfferInput;

    public String getSaveGameOfferInput() {
        return saveGameOfferInput;
    }

    public void setSaveGameOfferInput(String saveGameOfferInput) {
        this.saveGameOfferInput = saveGameOfferInput;
    }

    public String getGameMenuInput() {
        return gameMenuInput;
    }

   public void setGameMenuInput(String gameMenuInput) {
       this.gameMenuInput = gameMenuInput;
   }

   public String getLoadMenuInput() {
       return loadMenuInput;
   }

   public void setLoadMenuInput(String loadMenuInput) {
       this.loadMenuInput = loadMenuInput;
   }
}
