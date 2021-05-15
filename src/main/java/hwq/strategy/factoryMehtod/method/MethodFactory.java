package hwq.strategy.factoryMehtod.method;

/**
 * @author haowq 2021/4/27 9:53
 * 一个工厂对应一种产品，用户只用知道 工厂名称
 * 相比于简单工厂模式，满足开闭原则，扩展工厂只需要继承工厂接口，不需要修改原有代码
 */
public interface MethodFactory {
    Animal newAnimal();
}
