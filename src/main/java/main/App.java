package main;

import javax.swing.*;

public class App{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Ball Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel panel = new GamePanel();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.init();
    }
}
