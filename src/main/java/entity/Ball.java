package entity;

import main.GamePanel;

import java.awt.*;

public class Ball extends Entity{

    GamePanel gp;

    public Ball(GamePanel gp) {
        super(gp);
        this.gp = gp;

        setDefault();
        getImage();
    }

    public void setDefault(){
        positionX = (gp.screenWidth / 2) - (gp.tileSize / 2);
        positionY = (gp.screenHeight / 2 - (gp.tileSize / 2));

        defaultSpeed = 3;
        xSpeed = defaultSpeed;
        ySpeed = defaultSpeed;
    }

    public void getImage(){
        image = setup("circle", gp.tileSize, gp.tileSize);
    }

    public void update(){
        positionX += xSpeed;
        positionY += ySpeed;

        if (positionX + gp.tileSize > gp.screenWidth || positionX < 0){
            xSpeed *= -1;
        }
        if (positionY + gp.tileSize > gp.screenHeight || positionY < 0){
            ySpeed *= -1;
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, positionX, positionY, gp.tileSize, gp.tileSize, null);
    }
}
