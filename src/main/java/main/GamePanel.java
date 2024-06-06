package main;

import entity.Ball;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public final int originalTileSize = 16;
    public final int scale = 4;

    public final int tileSize = originalTileSize * scale;
    public final int maxCol = 16;
    public final int maxRow = 9;

    public final int screenWidth = tileSize * maxCol;
    public final int screenHeight = tileSize * maxRow;

    //FPS
    final int FPS = 60;

    //CLASSES
    public KeyHandler keyH = new KeyHandler();
    Ball ball = new Ball(this);
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.PINK);
    }

    public void init(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            if (timer >= 1000000000) {
                timer = 0;
            }
        }
    }

    public void update(){
        ball.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        ball.draw(g2);
    }
}
