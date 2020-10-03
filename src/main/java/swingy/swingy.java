package swingy;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import swingy.utilities.InputUtility;

public class swingy {

    public static void main(String[] args) {
        swingit();
    }

    public static void swingit() {
        JFrame f = new JFrame();
        JPanel panel = new JPanel(new MigLayout("wrap " + 25));
        int i = 25 * 25;
        int preferredWidth = 9;
        int preferredHeight = 9;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        while (i-- > 0) {
            JButton butt = new JButton("j");
            butt.setSize(10, 10);
            panel.add(butt);
        }

        JScrollPane scrollableTextArea = new JScrollPane(panel);  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        f.add(scrollableTextArea);
        f.setVisible(true);
    }

    public static String cliit() {
        System.out.println("Enter your name!");
        return InputUtility.getUserInput();
    }
}
