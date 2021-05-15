package hwq;

import hwq.factory.BaseBullet;
import hwq.factory.BaseTank;

import java.awt.*;

/**
 * @author haowq 2021/4/10 11:47
 */
public class Bullet extends BaseBullet {
    //速度
    private static final int SPEED = 8;
    private int x, y;
    private Dir dir;
    private Boolean living = true;
    private TankFrame tankFrame = null;
    private Group group = Group.BAD;
    private Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
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


    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;

        //创建时添加到tf中
        tankFrame.bullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            //如果没活着  删除自己
            tankFrame.bullets.remove(this);
        }
//        Color color = g.getColor();
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(Color.RED);

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
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

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }


    public void collideWith(BaseTank tank) {
        //队友互不伤害
        if (this.group == tank.getGroup()) return;
//         可能产生内存泄漏
//        Rectangle bulletRect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//        Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
//        Rectangle intersection = bulletRect.intersection(tankRect);
        if (tank.getGroup() == Group.BAD && !this.rect.intersection(tank.getRect()).isEmpty()) {
            this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tankFrame.explodes.add(new Explode(eX, eY, tankFrame));
        }
    }

    public void die() {
        this.living = false;
    }
}
