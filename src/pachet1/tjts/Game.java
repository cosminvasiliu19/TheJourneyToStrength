package pachet1.tjts;

import pachet1.tjts.gfx.Sprite;
import pachet1.tjts.gfx.SpriteSheet;
import pachet1.tjts.gfx.gui.Launcher;
import pachet1.tjts.input.KeyboardInput;
import pachet1.tjts.input.MouseInput;
import pachet2.entity.tjts.Entity;
import pachet2.entity.tjts.mob.EnemySquirtle;
import pachet2.entity.tjts.mob.Player;
import pachet3.tile.tjts.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 192; //public pentru a putea accesa dimensiunile din interiorul oricarei clase din proiect;
    public static final int HEIGHT = 108;//cu static, nu trebuie creata o instanta de fiecare data cand vrem sa accesam dimensiunile;
    public static final int SCALE = 10;   // final, o data ce e declarata o variabila, valoarea ei nu mai poate fi schimbata;
    public static final String TITLE = "The Journey to Strength";

    private Thread thread;
    private boolean running = false;
    private static BufferedImage background;
    public static SpriteSheet sheet, sheet1, sheet2, sheet3, sheet4, sheet5, sheet6, sheet7, sheet8, sheet9,sheet10,sheet11,sheet12,sheet13,
            sheet14,sheet15,sheet16,sheet17,sheet18,sheet19,sheet20,sheet21,sheet22,sheet23,sheet24,sheet25,sheet26, sheet27;
    public static Handler handler;
    public static Camera cam = new Camera();
    public static Sprite star;
    public static Sprite live;
    public static int stars = 0;
    public static int lives = 3;
    public static int playerX,playerY;
    public static int lavadeath;

    public static Sprite Charmander[] = new Sprite[16];
    public static Sprite Squirtle;


    public static Sprite tree;
    public static Sprite treeup;
    public static Sprite thistle;
    public static Sprite veg1;
    public static Sprite veg2;
    public static Sprite volcano;
    public static Sprite purplediamond;
    public static Sprite bluediamond;
    public static Sprite goldendiamond;
    public static Sprite rock1;
    public static Sprite rock2;
    public static Sprite burnedgrass;
    public static Sprite classicdiamond;
    public static Sprite finalreward;

    public static Sprite lavafloor;
    public static Sprite jumpplat;
    public static Sprite jumpplatright;
    public static Sprite jumpplatleft;
    public static Sprite jumpplat1;
    public static Sprite jumpplat2;
    public static Sprite edgecliffleft;
    public static Sprite edgecliffright;
    public static Sprite midcliff;
    public static Sprite lava;
    public static boolean playing = false;
    public static boolean death = false;
    public static boolean leveladv = false;
    public static boolean endgame = false;
    public static String getTitle(){return TITLE;}
    public static MouseInput MouseInput = new MouseInput();
    public static Launcher launcher;

    public static Scanner level1 = new Scanner(Handler.class.getResourceAsStream("/Level1Matrix.txt"));
    public static Scanner level2 = new Scanner(Handler.class.getResourceAsStream("/Level2Matrix.txt"));

    public static Sound jump;
    public static Sound CharName;
    public static Sound SquirName;
   // public static Sound themeSong;
    public static Sound losealife;




    public Game() {
        Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    private void init() throws IOException {

        handler = new Handler();
        launcher = new Launcher();
        sheet = new SpriteSheet("/css_sprites.png");
        sheet1 = new SpriteSheet("/Reversed.png");
        sheet2 = new SpriteSheet("/Enemy/1l.png");
        sheet3 = new SpriteSheet("/MapSprites/Star.png");
        sheet4 = new SpriteSheet("/MapSprites/25.png");
        sheet5 = new SpriteSheet("/MapSprites/Lives.png");
        sheet6 = new SpriteSheet("/MapSprites/24.png");
        sheet7 = new SpriteSheet("/MapSprites/32.png");
        sheet8 = new SpriteSheet("/MapSprites/26.png");
        sheet9 = new SpriteSheet("/MapSprites/34.png");
        sheet10 = new SpriteSheet("/MapSprites/27.png");
        sheet11 = new SpriteSheet("/MapSprites/25.png");
        sheet12 = new SpriteSheet("/MapSprites/28.png");
        sheet13 = new SpriteSheet("/MapSprites/30.png");
        sheet14 = new SpriteSheet("/MapSprites/31.png");
        sheet15 = new SpriteSheet("/MapSprites/33.png");
        sheet16 = new SpriteSheet("/MapSprites/29.png");
        sheet17 = new SpriteSheet("/MapSprites/8.png");
        sheet18 = new SpriteSheet("/MapSprites/18.png");
        sheet19 = new SpriteSheet("/MapSprites/9.png");
        sheet20 = new SpriteSheet("/MapSprites/19.png");
        sheet21 = new SpriteSheet("/MapSprites/17.png");
        sheet22 = new SpriteSheet("/MapSprites/4.png");
        sheet23 = new SpriteSheet("/MapSprites/5.png");
        sheet24 = new SpriteSheet("/MapSprites/13.png");
        sheet25 = new SpriteSheet("/MapSprites/22.png");
        sheet26 = new SpriteSheet("/MapSprites/ClassicDiamond.png");
        sheet27 = new SpriteSheet("/MapSprites/BlueDiamond.png");



        addKeyListener(new KeyboardInput());
        addMouseListener(MouseInput);
        addMouseMotionListener(MouseInput);


        lavafloor = new Sprite(sheet,2,3);
        Charmander[0] = new Sprite(sheet,5,1);
        Charmander[1] = new Sprite(sheet,5,2);
        Charmander[2] = new Sprite(sheet,5,3);
        Charmander[3] = new Sprite(sheet,5,4);
        Charmander[4] = new Sprite(sheet,1,5);
        Charmander[5] = new Sprite(sheet,2,5);
        Charmander[6] = new Sprite(sheet,3,5);
        Charmander[7] = new Sprite(sheet,5,1);
        Charmander[8] = new Sprite(sheet1,1,1);
        Charmander[9] = new Sprite(sheet1,2,2);
        Charmander[10] = new Sprite(sheet1,1,3);
        Charmander[11] = new Sprite(sheet1,2,3);
        Charmander[12] = new Sprite(sheet1,3,1);
        Charmander[13] = new Sprite(sheet1,3,2);
        Charmander[14] = new Sprite(sheet1,3,3);
        Charmander[15] = new Sprite(sheet1,1,1);

        Squirtle = new Sprite(sheet2,1,1);
   /*     Squirtle[1] = new Sprite(sheet2,1,3);
        Squirtle[2] = new Sprite(sheet2,1,5);
        Squirtle[3] = new Sprite(sheet2,1,7);
        Squirtle[4] = new Sprite(sheet2,2,1);
        Squirtle[5] = new Sprite(sheet2,2,3);
        Squirtle[6] = new Sprite(sheet2,1,1);
        Squirtle[7] = new Sprite(sheet2,1,2);
        Squirtle[8] = new Sprite(sheet2,1,4);
        Squirtle[9] = new Sprite(sheet2,1,6);
        Squirtle[10] = new Sprite(sheet2,1,8);
        Squirtle[11] = new Sprite(sheet2,2,2);
        Squirtle[12] = new Sprite(sheet2,2,4);
        Squirtle[13] = new Sprite(sheet2,1,2);
*/
        tree = new Sprite(sheet4,1,2);
        treeup = new Sprite(sheet11,1,1);
        star = new Sprite(sheet3,1,1);
        live = new Sprite(sheet5,1,1);
        purplediamond = new Sprite(sheet6,1,1);
        bluediamond = new Sprite(sheet7,1,1);
        goldendiamond = new Sprite(sheet8,1,1);
        veg1 = new Sprite(sheet9,1,1);
        veg2 = new Sprite(sheet10,1,1);
        volcano = new Sprite(sheet12, 1,1);
        rock1 = new Sprite(sheet13,1,1);
        rock2 = new Sprite(sheet14,1,1);
        thistle = new Sprite(sheet15,1,1);
        burnedgrass = new Sprite(sheet16,1,1);
        classicdiamond = new Sprite(sheet26,1,1);
        finalreward = new Sprite(sheet27,1,1);

        jumpplat = new Sprite(sheet17,1,1);
        jumpplatright = new Sprite(sheet18,1,1);
        jumpplatleft = new Sprite(sheet19,1,1);
        jumpplat1 = new Sprite(sheet20,1,1);
        jumpplat2 = new Sprite(sheet21,1,1);
        edgecliffleft = new Sprite(sheet22,1,1);
        edgecliffright = new Sprite(sheet23,1,1);
        midcliff = new Sprite(sheet24,1,1);
        lava = new Sprite(sheet25,1,1);

        handler.createLevel(level1);
        handler.addEntity(new EnemySquirtle(5632,HEIGHT*SCALE,128,128,true,Id.enemy,handler));
        handler.addEntity(new Player(0,HEIGHT*SCALE ,128,128,true,Id.player,handler));


        try{
            background= ImageIO.read(getClass().getResource("/background.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        jump = new Sound("/sound/jump.wav");
        //themeSong = new Sound("/sound/themeSong.wav");
        CharName = new Sound("/sound/charmander.wav");
        SquirName = new Sound("/sound/Squirtle.wav");
        losealife = new Sound("/sound/losealife.wav");
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(background,0,0,getWidth(),getHeight(),null);
        if(playing)
        {
            g.translate(Camera.getX(), Camera.getY());
            Handler.render(g);
        }
        else {
            launcher.render(g);
        }

        if(endgame == true)
        {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Fuuka",Font.LAYOUT_RIGHT_TO_LEFT,75));
        g.drawImage(live.getBufferedImage(),Game.getVisibleArea().x,Game.getVisibleArea().y+128,100,100,null);
        g.drawString("CONGRATULATIONS",Game.getVisibleArea().x+484,Game.getVisibleArea().y+400);
        }
        g.dispose();
        bs.show();
    }

    public void tick() {
        handler.tick();
        for(Entity e:handler.entity){
            if(e.getId()==Id.player){
                cam.tick(e);
            }
        }
        if(death)
        {
            handler.clearLevel();
            if(leveladv)
                handler.createLevel(level2);
            else
                handler.createLevel(level1);
            handler.addEntity(new EnemySquirtle(5632,HEIGHT*SCALE,128,128,true,Id.enemy,handler));
            handler.addEntity(new Player(0,HEIGHT*SCALE ,128,128,true,Id.player,handler));
            death=false;
        }
    }

    public static int getFrameWidth(){
        return WIDTH*SCALE;
    }
    public static int getFrameHeight(){
        return HEIGHT*SCALE;
    }
    public static Rectangle getVisibleArea() {
        Entity e = null;
        for (int i = 0; i < handler.entity.size(); i++) {
            if(handler.entity.get(i).getId()==Id.player)
                e = handler.entity.get(i);
        }
        playerX = e.getX();
        playerY = e.getY();
        return new Rectangle(playerX - (getFrameWidth() / 2 - 5), playerY - (getFrameHeight() / 2 - 5), getFrameWidth() + 10, getFrameHeight() + 10);

    }
    public static int getLavadeath(){
        LinkedList<Tile> tempList = handler.tile;

        Comparator<Tile> tileSorter = new Comparator<Tile>() {

            public int compare(Tile t1, Tile t2) {
                if(t1.getY()>t2.getY()) return -1;
                if(t1.getY()<t2.getY()) return 1;
                return 0;
            }

        };

        Collections.sort(tempList,tileSorter);
        return tempList.getFirst().getY() + tempList.getFirst().getHeight();
    }
    private synchronized void start() {
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    private synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestFocus();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0;
        double ns = 1000000000.0/60.0;
        int frames = 0;
        int ticks = 0;
        while(running){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                System.out.println(frames + " Frames per Second " + ticks + " Updates per Second ");
                frames =0;
                ticks =0;
            }
        }
        stop();
    }
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        JFrame frame = new JFrame(TITLE);
        frame.add(game); // adauga continutul din constructorul Game in frame
        frame.pack(); //
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();
        //System.exit(0);
    }
}
