package hwq.factory;

import hwq.Dir;
import hwq.Group;
import hwq.TankFrame;

import java.awt.*;

/**
 * @author haowq 2021/4/28 16:30
 */
public abstract class BaseTank {
    public int x = 200;
    public int y = 300;

    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir left);

    public abstract Group getGroup();

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

    public abstract Rectangle getRect();

    public abstract TankFrame getTankFrame();

    public abstract Dir getDir();

}
