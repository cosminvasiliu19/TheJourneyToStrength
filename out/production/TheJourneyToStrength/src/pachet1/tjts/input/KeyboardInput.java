package pachet1.tjts.input;

import pachet1.tjts.Game;
import pachet2.entity.tjts.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        for(Entity en: Game.handler.entity)
        switch(key){
            case KeyEvent.VK_W:
                if(!en.jumping) {
                    en.jumping = true;
                    en.gravity = 8;
                    en.setVelY(0);

                    Game.jump.play();
                }
                break;
            case KeyEvent.VK_A:
                en.setVelX(-5);
                en.facing=0;
                break;
            case KeyEvent.VK_D:
                en.setVelX(5);
                en.facing=1;
                break;

            case KeyEvent.VK_ESCAPE:
                Game.playing = false;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        for(Entity en: Game.handler.entity)
            switch(key){
                case KeyEvent.VK_W:
                    en.setVelY(0);
                    break;
                case KeyEvent.VK_A:
                    en.setVelX(0);
                    break;
                case KeyEvent.VK_D:
                    en.setVelX(0);
                    break;
            }
    }
}
