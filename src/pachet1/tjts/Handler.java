package pachet1.tjts;

import pachet2.entity.tjts.Entity;
import pachet3.tile.tjts.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

import static pachet1.tjts.Game.*;


public class Handler {
    public static LinkedList<Entity> entity = new LinkedList<Entity>();
    public static LinkedList<Tile> tile = new LinkedList<Tile>();

    /*public Handler() {
        createLevel();
    }*/
    public static void render(Graphics g) {

        for (Tile ti : tile) {
            ti.render(g);
        }
        for (Entity en : entity) {
            en.render(g);
        }
        g.setColor(Color.GREEN);
        g.setFont(new Font("Kuroko",Font.LAYOUT_RIGHT_TO_LEFT,75));
        g.drawImage(live.getBufferedImage(),Game.getVisibleArea().x,Game.getVisibleArea().y+128,100,100,null);
        g.drawString("x" + lives,Game.getVisibleArea().x+128,Game.getVisibleArea().y+224);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Haikyuu",Font.LAYOUT_RIGHT_TO_LEFT,75));
        g.drawString("x" + stars,Game.getVisibleArea().x+128,Game.getVisibleArea().y+96);
        g.drawImage(star.getBufferedImage(),Game.getVisibleArea().x,Game.getVisibleArea().y,100,100,null);

    }
    public void tick() {
        for (Entity en : entity) {
            en.tick();
        }
        for (Tile ti : tile) {
            ti.tick();
        }
    }
    public void addEntity(Entity en) {
        entity.add(en);
    }
    public void removeEntity(Entity en) {
        entity.remove(en);
    }
    public void addTile(Tile ti) {
        tile.add(ti);
    }
    public void removeTile(Tile ti) {
        tile.remove(ti);
    }
    public static int map[][];
    public void createLevel(Scanner scanner) {
        String vector[] = null;
        map = new int[12][48];
        Scanner input = scanner;

        for (int i = 0; i < 12; i++) {
            if (input.hasNextLine()) {
                vector = input.nextLine().split(",");
            }
            for (int j = 0; j < 48; j++) {
                map[i][j] = Integer.parseInt(vector[j]);
                //System.out.println(map[i][j]);
            }
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 48; j++) {
                if ((map[i][j]!=87)&&((map[i][j] !=88)&&map[i][j]!=5)&&(map[i][j]!=10)&&(map[i][j]!=6)&&(map[i][j]!=7)&&(map[i][j]!=9)&&(map[i][j]!=11)&&(map[i][j]!=4)&&(map[i][j]!=8)&&(map[i][j]!=3)&&(map[i][j] != -1) && (map[i][j] != 72) &&(map[i][j] != 53)
                        && (map[i][j] != 27) && (map[i][j] != 29) && (map[i][j] != 25) && (map[i][j] != 31) && (map[i][j] != 24) && (map[i][j] != 23) && (map[i][j] != 32) && (map[i][j] != 33) && (map[i][j] != 30) && (map[i][j] != 28) && (map[i][j] != 26)) {
                    addTile(new Wall(j * 128, i * 128, 128, 128, true, Id.wall, this));
                }
                if(map[i][j]==10)
                {
                    addTile(new MidCliff(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==3)
                {
                    addTile(new JumpPlat(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==11)
                {
                    addTile(new JumpPlat1(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==9)
                {
                    addTile(new JumpPlat2(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==8)
                {
                    addTile(new JumpPlatRight(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==4)
                {
                    addTile(new JumpPlatLeft(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==6)
                {
                    addTile(new EdgeCliffLeft(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==7)
                {
                    addTile(new EdgeCliffRight(j * 128, i * 128, 128, 128, true,Id.wall,this));
                }
                if(map[i][j]==53)
                {
                    addTile(new Star(j * 128, i * 128, 128, 128, true,Id.star,this));
                }
                if(map[i][j]==23)
                {
                    addTile(new PurpleDiamond(j * 128, i * 128, 128, 128, true,Id.purplediamond,this));
                }
                if(map[i][j]==31)
                {
                    addTile(new BlueDiamond(j * 128, i * 128, 128, 128, true,Id.bluediamond,this));
                }
                if(map[i][j]==25)
                {
                    addTile(new GoldenDiamond(j * 128, i * 128, 128, 128, true,Id.goldendiamond,this));
                }
                if(map[i][j]==33)
                {
                    addTile(new Veg1(j * 128, i * 128, 128, 128, true,Id.veg1,this));
                }
                if(map[i][j]==26)
                {
                    addTile(new Veg2(j * 128, i * 128, 128, 128, true,Id.veg2,this));
                }
                if(map[i][j]==24)
                {
                    addTile(new Tree(j * 128, i * 128, 128, 128, true, Id.tree, this));
                }
                if(map[i][j]==72)
                {
                    addTile(new Treeup(j * 128, i * 128, 128, 128, true, Id.treeup, this));
                }
                if(map[i][j]==27)
                {
                    addTile(new Volcano(j * 128, i * 128, 128, 128, true, Id.volcano, this));
                }
                if(map[i][j]==29)
                {
                    addTile(new Rock1(j * 128, i * 128, 128, 128, true, Id.rock1, this));
                }
                if(map[i][j]==30)
                {
                    addTile(new Rock2(j * 128, i * 128, 128, 128, true, Id.rock2, this));
                }
                if(map[i][j]==32)
                {
                    addTile(new Thistle(j * 128, i * 128, 128, 128, true, Id.thistle, this));
                }
                if(map[i][j]==28)
                {
                    addTile(new BurnedGrass(j * 128, i * 128, 128, 128, true, Id.burnedgrass, this));
                }
                if(map[i][j]==88)
                {
                    addTile(new ClassicDiamond(j * 128, i * 128, 128, 128, true, Id.classicdiamond, this));
                }
                if(map[i][j]==87)
                {
                    addTile(new FinalReward(j * 128, i * 128, 128, 128, true, Id.finalreward, this));
                }
                if(i==11)
                {
                    addTile(new Lava(j * 128, i * 128, 128, 128, true,Id.lava,this));
                }
            }
        }
        Game.lavadeath = Game.getLavadeath();
    }
    public void clearLevel(){
        entity.clear();
        tile.clear();
    }
}

