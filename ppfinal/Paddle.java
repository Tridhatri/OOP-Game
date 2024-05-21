import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Paddle {
    int x, y, width, height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}