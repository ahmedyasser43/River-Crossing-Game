package main;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Sprite
{
    private Image image;
     double posX;
     double posY;
    private double width;
    private double height;
     double deltaX;
     double deltaY;

    public Sprite(Image image)
    {
        this.image = image;
        this.posX = 0;
        this.posY = 450;
        width = image.getWidth();
        height = image.getHeight();
    }

    public Sprite() {

    }

    private Rectangle2D getBoundry() {
        return new Rectangle2D(posX,posY,width,height);
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public Image getImage()
    {
        return image;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void getPosY(double posY) {
        this.posY = posY;
    }
    public void getPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setDeltaX(double x) { this.deltaX = x; }

    public void setDeltaY(double y) { this.deltaY = y; }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean intersects(Sprite sprite) {
        return this.getBoundry().intersects(sprite.getBoundry());
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image,posX,posY);
    }

    public void update() {
        this.posX += deltaX;
        this.posY += deltaY;
        deltaX = 0;
        deltaY = 0;
    }

    public Boolean contains (double clickedX, double clickedY) {
        return this.getBoundry().contains(clickedX, clickedY);
    }
}
