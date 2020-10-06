/* This is a utility class provided as an answer to a question on how to find the selected radio button in a button group. 
Given that it is a simple looper running 'isSelected', I don't see how I can really change it to make it my own. 
Adding this comment here to document/note why there is an unoriginal utility class in my project* ~ Kyle */

package swingy.utilities;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class GroupButtonUtils {

    public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                System.out.println(button.getText());
                return button.getText();
            }
        }

        return null;
    }
}