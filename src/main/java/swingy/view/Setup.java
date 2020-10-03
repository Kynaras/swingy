package swingy.view;

public class Setup {
    JFrame f = new JFrame();
        JLabel title = new JLabel("Swingy");
        JButton newGame = new JButton("New Hero");
        JButton loadGame = new JButton("Load Hero");

        
        JPanel menuPanel = new JPanel(new MigLayout());
        menuPanel.add(title, "span");
        menuPanel.add(newGame, "span");
        menuPanel.add(loadGame, "span");
        f.add(menuPanel);
        f.setSize(400, 400);
        f.setVisible(true);
}
