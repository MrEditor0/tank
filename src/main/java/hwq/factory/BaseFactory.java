package hwq.factory;

import hwq.Dir;
import hwq.Group;
import hwq.TankFrame;

/**
 * @author haowq 2021/4/28 16:29
 */
public abstract class BaseFactory {
    public abstract BaseBullet newBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseTank newTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseExplode newExplode(int x, int y,TankFrame tankFrame);
}
