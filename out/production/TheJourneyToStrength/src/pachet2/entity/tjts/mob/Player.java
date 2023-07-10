package pachet2.entity.tjts.mob;

import pachet1.tjts.Game;
import pachet1.tjts.Handler;
import pachet1.tjts.Id;
import pachet2.entity.tjts.Entity;
import pachet3.tile.tjts.Tile;

import java.awt.*;

import static pachet1.tjts.Game.*;

public class Player extends Entity {

    private int frame = 0;
    private int frameDelay = 0;
    private boolean animate = false;

    public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
        super(x, y, width, height, solid, id, handler);

    }
    @Override
    public void render(Graphics g) {
        if (facing == 0) {
            g.drawImage(Game.Charmander[frame+8].getBufferedImage(), x, y, width, height, null);
        }else if(facing==1){
            g.drawImage(Game.Charmander[frame].getBufferedImage(), x, y, width, height, null);

        }
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
        if(getY()>=Game.lavadeath) {
            Game.lives = 0;
        }//if(x+width >=1920) x=1920-width;
        //wif(y+height >= 1080) y = 1080 - height;
        if(velX!=0&& falling && !jumping && velY==0) animate = true;
        else animate = false;

      for (int i = 0; i<handler.entity.size();i++)
        {
            Entity en = handler.entity.get(i);
            if(!en.solid) break;
            if(en.getId()==Id.enemy){
                if(getBoundsBottom().intersects(en.getBoundsTop()))
                {
                    en.die();

                }
                if(getBounds().intersects(en.getBounds())){

                        Game.lives --;
                        if(Game.lives==0)
                        {
                            die();
                        }
                        else
                        {
                            if(facing == 0)
                            {
                                x+=128;
                            }
                            else{
                                x-=128;
                            }
                        }
                }
                if(Game.lives == 0){
                    Game.lives = 3;
                    //Game.stars = 0;
                    //handler.clearLevel();
                  //  handler.createLevel();
                    handler.addEntity(new Player(0,HEIGHT*SCALE ,128,128,true,Id.player,handler));
                  //  handler.addEntity(new EnemySquirtle(5632,HEIGHT*SCALE,128,128,true,Id.enemy,handler));
                }
            }
            }

        for (int i = 0; i<handler.tile.size();i++){
            Tile t = handler.tile.get(i);
            if(!t.solid) break;
            if(t.getId()==Id.wall){
                if(getBoundsTop().intersects(t.getBounds())&&t.getId()!=Id.star){
                    setVelY(0);
                    if(jumping){
                        jumping= false;
                        gravity=0.5;
                        falling= true;
                    }
                }
                if(getBoundsBottom().intersects(t.getBounds())&&t.getId()!=Id.star){
                    setVelY(0);
                    if(falling) falling = false;
                }
                    else {
                        if(!falling &&!jumping){
                            gravity=0.5;
                            falling = true;
                    }
                }
                if(getBoundsLeft().intersects(t.getBounds())&&t.getId()!=Id.star){
                    setVelX(0);
                    x = t.getX()+t.width;
                }
                if(getBoundsRight().intersects(t.getBounds())&&t.getId()!=Id.star){
                    setVelX(0);
                    x = t.getX()-t.width;
                }

            }
                if(getBounds().intersects(t.getBounds())&&t.getId()==Id.star){
                    stars++;
                    t.die();
                }
                if(stars ==3 ){
            if(getBounds().intersects(t.getBounds()) && t.getId()==Id.classicdiamond && Game.leveladv==true)
            {
                //Game.finish=true;
                Game.playing=false;
            }
            else
            if (getBounds().intersects(t.getBounds()) && t.getId()==Id.classicdiamond) {
                Game.leveladv = true;
                stars = 0;
                Game.death=true;

            }

        }
                if(stars == 3){
            if (getBounds().intersects(t.getBounds()) && t.getId()==Id.finalreward) {
                endgame = true;
            }
        }
        }
        if(jumping){
            gravity-=0.1;
            setVelY((int)-gravity);
            if(gravity<=0.0){
                jumping = false;
                falling=true;
            }
        }
        if(falling){
            gravity+=0.1;
            setVelY((int)gravity);
        }
        if(animate){
            frameDelay++;
            if(frameDelay>=3){
                frame++;
                if(frame>=8){
                    frame = 0;
                }
                frameDelay = 0;
            }
        }
        if(!animate){
            if(facing == 0){
                frame=7;
            }
            else if(facing == 1){
                frame=0;
            }
        }


    }
}
