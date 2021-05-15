package hwq.strategy.factoryMehtod.method;

/**
 * @author haowq 2021/4/27 9:58
 */
public class HorseFactory implements MethodFactory {

    @Override
    public Animal newAnimal() {
        return new Horse();
    }
}
