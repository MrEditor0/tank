package hwq.strategy.factoryMehtod.astarctFactory;

/**
 * @author haowq 2021/4/27 10:06
 */
public class GoodAbastractFactory implements AbstractFactroy {
    @Override
    public Tank newTank() {
        return new GoodTank();
    }

    @Override
    public Bullet newBullet() {
        return new GoodBullet();
    }
}
