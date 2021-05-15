package hwq.strategy.factoryMehtod;

/**
 * @author haowq 2021/4/25 10:06
 * 简单工厂，扩展性不好,扩展违反开闭原则
 */
public class SimpleFactory {
    public Car createCar(){
        return  new Car();
    }
    public Plane createPlane(){
        return new Plane();
    }
    //other create operator
}
