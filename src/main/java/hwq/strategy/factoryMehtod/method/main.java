package hwq.strategy.factoryMehtod.method;

/**
 * @author haowq 2021/4/27 9:59
 */
public class main {
    public static void main(String[] args) {
        CowFactory factory = new CowFactory();
        factory.newAnimal().show();
    }
}
