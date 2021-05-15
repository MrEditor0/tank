package hwq.strategy.impl;

import hwq.Bullet;
import hwq.Tank;
import hwq.factory.BaseTank;
import hwq.strategy.FireStrategy;

/**
 * @author haowq 2021/4/21 8:55
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        //t.getTankFrame().bullets.add(new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getTankFrame()));
        t.getTankFrame().factory.newBullet(bX, bY, t.getDir(), t.getGroup(), t.getTankFrame());
        //new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getTankFrame());
    }
}
