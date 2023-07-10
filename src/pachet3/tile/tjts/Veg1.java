package pachet3.tile.tjts;

import pachet1.tjts.Game;
import pachet1.tjts.Handler;
import pachet1.tjts.Id;

import java.awt.*;

public class Veg1 extends Tile{
    public Veg1(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.veg1.getBufferedImage(),x,y,width,height,null);
    }

    @Override
    public void tick() {

    }
}
