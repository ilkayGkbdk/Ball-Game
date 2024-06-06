package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {

    public BufferedImage image;
    public GamePanel gp;

    public int positionX;
    public int positionY;

    public int defaultSpeed;
    public int xSpeed;
    public int ySpeed;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void update(){

    }

    public void draw(Graphics2D g2){

    }

    public BufferedImage setup(String imagePath, int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/" + imagePath + ".png")));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }
}
