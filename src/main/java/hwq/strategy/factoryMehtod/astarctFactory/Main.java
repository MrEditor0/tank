package hwq.strategy.factoryMehtod.astarctFactory;

/**
 * @author haowq 2021/4/27 10:07
 * 抽象工厂
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactroy factroy = new GoodAbastractFactory();
        factroy.newBullet().shoot();
        factroy.newTank().move();
    }
}
