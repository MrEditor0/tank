package hwq.factory;

import hwq.Dir;
import hwq.Group;
import hwq.TankFrame;

/**
 * @author haowq 2021/4/28 16:49
 */
public class ReactFactory extends BaseFactory {
    @Override
    public BaseBullet newBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new ReactBullet(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseTank newTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new ReactTank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExplode newExplode(int x, int y, TankFrame tankFrame) {
        return new ReactExplode(x,y,tankFrame);
    }
}
