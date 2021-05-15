package hwq;


import hwq.factory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @author haowq 2021/4/9 10:11
 */
public class TankFrame extends Frame {

    public int x = 200;
    public int y = 300;

    //public BaseFactory factory = new ReactFactory();
    public BaseFactory factory = new DefaultFactory();
    BaseTank myTank  = factory.newTank(x, y, Dir.DOWN, Group.GOOD,this);

   // Tank myTank = new Tank(x, y, Dir.DOWN, Group.GOOD,this);
    Explode explode = new Explode(x,y,this);

    public List<BaseBullet> bullets = new ArrayList<>();
    public List<BaseExplode> explodes = new ArrayList<>();
    public static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;

    public List<Tank> badTanks  = new ArrayList<>();

    public List<Tank> getBadTanks() {
        return badTanks;
    }

    public void setBadTanks(List<Tank> badTanks) {
        this.badTanks = badTanks;
    }

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyAdapter());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    //二次缓存去除闪烁
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹个数"+bullets.size(),10,60);
        g.drawString("敌人个数"+badTanks.size(),10,80);
        g.drawString("命中爆炸个数"+explodes.size(),10,80);

        //tank 自己画自己
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < badTanks.size(); i++) {
            badTanks.get(i).paint(g);
        }

        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).collideWith(myTank);
            for(int j = 0;j<badTanks.size();j++){
               bullets.get(i).collideWith(badTanks.get(j));
            }
        }
        for(int i = 0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }
    }

    class MyKeyAdapter extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
            System.out.println("keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
            System.out.println("keyReleased");
        }

        private void setMainTankDir() {

            if (!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
                System.out.println("坦克停了");
            } else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }
}
