package pachet1.tjts.gfx.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pachet1.tjts.DataBase;
import pachet1.tjts.Game;

public class Button {

    public int x, y;
    public int width, height;
    public String label;

    public Button(int x, int y, int width, int height, String label, BufferedImage read) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
    }
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Century Gothic",Font.BOLD,50));

        FontMetrics fm = g.getFontMetrics();
        int stringX = (getWidth() - fm.stringWidth(getLabel())) / 2;
        int stringY = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(getLabel(), getX() + stringX, getY() + stringY);
    }
    public void triggerEvent() {
        if(getLabel().toLowerCase().contains("start")) Game.playing = true;
        else if(getLabel().toLowerCase().contains("exit"))
        {
            DataBase db = new DataBase();
            db.save();
            db.close();
            System.exit(0);
        }
        else if(getLabel().toLowerCase().contains("load"))
        {
            DataBase db = new DataBase();
            db.load();
            db.close();
            Game.playing = true;
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

}