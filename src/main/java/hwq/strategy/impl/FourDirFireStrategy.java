package hwq.strategy.impl;

import hwq.Bullet;
import hwq.Dir;
import hwq.Tank;
import hwq.factory.BaseTank;
import hwq.strategy.FireStrategy;

import java.io.FileReader;

/**
 * @author haowq 2021/4/21 9:10
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();

        for (Dir dir : dirs) {
            t.getTankFrame().factory.newBullet(bX, bY, dir, t.getGroup(), t.getTankFrame());
            //new Bullet(bX, bY, dir, t.getGroup(), t.getTankFrame());
        }
    }

}
