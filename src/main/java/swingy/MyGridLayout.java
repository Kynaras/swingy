package swingy;

import java.awt.*;
import javax.swing.*;  
  
public class MyGridLayout{  
    JFrame f;
    JPanel p;
    GridLayout layout = new GridLayout(9,9);

    MyGridLayout(){  
        layout.setHgap(25);
        layout.setVgap(25);
        f=new JFrame();  
        p = new JPanel();
        int i = 81;
        p.setMaximumSize(new Dimension(400, 400));
        while (i-- > 0) {
            JButton bb = new JButton("2");
            bb.setSize(40, 400);
            p.add(bb);


        }
;          
        f.add(p);
        //setting flow layout of right alignment  
        f.setSize(200, 200);  
        f.setVisible(true);   
}  
public static void main(String[] args) {  
    new MyGridLayout();  
}  
}  