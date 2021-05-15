package hwq.factory;

import java.awt.*;

/**
 * @author haowq 2021/4/28 16:30
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank myTank);

}
