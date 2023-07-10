package pachet1.tjts;

import pachet2.entity.tjts.Entity;

public class Camera {
    public static int x;
    public static int y;

    public void tick(Entity player){
        setX(-player.getX()+Game.getFrameWidth()/2);
        setY(-player.getY()+Game.getFrameHeight()/2);

    }
    public static int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
