package hwq.strategy.factoryMehtod.method;

/**
 * @author haowq 2021/4/27 9:55
 */
public class CowFactory implements MethodFactory{
    @Override
    public Animal newAnimal() {
        return  new Cow();
    }
}
