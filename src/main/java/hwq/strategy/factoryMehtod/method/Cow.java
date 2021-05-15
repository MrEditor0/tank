package hwq.strategy.factoryMehtod.method;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

/**
 * @author haowq 2021/4/27 9:56
 */
public class Cow implements Animal {
    @Override
    public void show() {
        System.out.println("mo  mo  mo  ....");
    }
}
