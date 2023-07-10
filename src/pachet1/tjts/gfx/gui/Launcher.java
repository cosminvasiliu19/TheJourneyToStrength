package pachet1.tjts.gfx.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import pachet1.tjts.Game;

import javax.imageio.ImageIO;

public class Launcher {

    public Button[] buttons;
    public BufferedImage menu;
    public Launcher() throws IOException {
        menu = ImageIO.read(getClass().getResourceAsStream("/meniu.png"));
        buttons = new Button[3];

        buttons[0]=new Button(275,100,200,150,"START",ImageIO.read(getClass().getResourceAsStream("/Start Button.png")));

        buttons[1]=new Button(298,300,150,150,"SAVE & EXIT", ImageIO.read(getClass().getResourceAsStream("/Exit Button.png")));
        buttons[2]=new Button(321, 500, 150, 150, "LOAD", ImageIO.read(getClass().getResourceAsStream("/Load Button.png")));
    }
    public void render(Graphics g) {
        g.drawImage(menu,0,0,Game.getFrameWidth(),Game.getFrameHeight(),null);

        for(int i=0;i<buttons.length;i++) {
            buttons[i].render(g);
        }
    }

}