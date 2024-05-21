import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ball {
    int x, y, width, height, speedX, speedY;

    public Ball(int x, int y, int width, int height, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
    }
}