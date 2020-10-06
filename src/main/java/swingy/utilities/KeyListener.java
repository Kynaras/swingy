package swingy.utilities;

class KeyListener implements KeyListener{
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_UP){
          statusLabel.setText("Entered text: " + textField.getText());
       }
    }
    public void keyReleased(KeyEvent e) {
    }   
 }