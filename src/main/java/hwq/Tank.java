package hwq;

import hwq.factory.BaseTank;
import hwq.strategy.FireStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author haowq 2021/4/9 14:23
 */
public class Tank extends BaseTank {
//    private int x = 200;
//    private int y = 300;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 3;
    private boolean moving = false;
    private TankFrame tankFrame = null;
    private BufferedImage bufferedImage = null;
    private Group group = Group.BAD;
    private Random random = new Random();
    private Rectangle rect = new Rectangle();
    private FireStrategy fireStrategy = null;

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private boolean living = true;

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;

        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void paint(Graphics g) {
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,50,50);
        if (!living) tankFrame.badTanks.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
        if (this.group == Group.GOOD && !moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        //UPDATE RECT
        rect.x = x;
        rect.y = y;

        if(this.group == Group.BAD && random.nextInt(10)>8) this.fire();
        if(this.group == Group.BAD && random.nextInt(100) > 95) randomDir();

        boundsCheck();


    }

    /**
     * 可以将策略以参数形式传入，但是需要将策略作为单例模式
     */
    public void fire() {

        if(this.group == Group.BAD){
            String fsName = (String) PropertyMgr.get("badFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(fsName).getDeclaredConstructor().newInstance();
                fireStrategy.fire(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //fireStrategy.fire(this);
        if(this.group == Group.GOOD) {
            String fsName = (String) PropertyMgr.get("goodFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(fsName).getDeclaredConstructor().newInstance();
                fireStrategy.fire(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH- Tank.WIDTH -2) x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT -2;
    }
    public void die() {
        this.living = false;
    }

    public void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }
}
