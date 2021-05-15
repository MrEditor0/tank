package hwq.strategy.factoryMehtod.astarctFactory;

/**
 * @author haowq 2021/4/27 10:01
 * 抽象工厂，有产品族的概念，两个维度，工厂维度和产品维度，
 * 工程维度上方便扩展，产品维度扩展的话违反开闭原则
 */
public interface AbstractFactroy {
    Tank newTank();
    Bullet newBullet();
}
