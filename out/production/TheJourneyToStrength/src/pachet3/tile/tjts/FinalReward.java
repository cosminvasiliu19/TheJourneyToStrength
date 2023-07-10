package pachet3.tile.tjts;

import pachet1.tjts.Game;
import pachet1.tjts.Handler;
import pachet1.tjts.Id;

import java.awt.*;

public class FinalReward extends Tile{
    public FinalReward(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.finalreward.getBufferedImage(),x,y,width,height,null);

    }

    @Override
    public void tick() {

    }
}
