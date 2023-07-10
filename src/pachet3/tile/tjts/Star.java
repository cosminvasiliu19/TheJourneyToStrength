package pachet3.tile.tjts;

import pachet1.tjts.Game;
import pachet1.tjts.Handler;
import pachet1.tjts.Id;

import java.awt.*;

public class Star extends Tile{
    public Star(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height,solid, id, handler);
    }

    public void render(Graphics g) {
        g.drawImage(Game.star.getBufferedImage(),x,y,width,height,null);
    }

    public void tick() {

    }

}
