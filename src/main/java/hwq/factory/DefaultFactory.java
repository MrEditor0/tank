package hwq.factory;

import hwq.*;

/**
 * @author haowq 2021/4/28 16:31
 */
public class DefaultFactory extends BaseFactory {

    @Override
    public BaseBullet newBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseTank newTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExplode newExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }
}
