package pachet2.entity.tjts.mob;

import pachet1.tjts.Game;
import pachet1.tjts.Handler;
import pachet1.tjts.Id;
import pachet2.entity.tjts.Entity;
import pachet3.tile.tjts.Tile;

import java.awt.*;
import java.util.Random;

public class EnemySquirtle extends Entity {
    private Random random = new Random();

    public EnemySquirtle(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);

        int direction = random.nextInt(4);
        switch (direction) {
        case 0:
            setVelX(5);
            facing = 0;
            break;
        case 1:
            setVelX(-5);
            facing = 1;
    }
}
    @Override
    public void render(Graphics g) {
        if (facing == 1)
           g.drawImage(Game.Squirtle.getBufferedImage(), x, y, width, height, null);
        else
            g.drawImage(Game.Squirtle.getBufferedImage(), x, y, width, height, null);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        for (int i = 0; i < Handler.tile.size(); i++) {
            Tile t = Handler.tile.get(i);
            if (t.isSolid()) {

                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling)
                        falling = false;
                } else if (!falling) {
                    falling = true;
                    gravity = 0.8;
                }

                if (getBoundsLeft().intersects(t.getBounds())) {
                    setVelX(5);
                    facing = 0;
                }
                if (getBoundsRight().intersects(t.getBounds())) {
                    setVelX(-5);
                    facing = 1;
                }

            }
        }
        if (falling) {
            gravity += 0.0;
            setVelY((int) gravity);
        }

    }
}
