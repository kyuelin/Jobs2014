package dev.kyuelin.citi.dpattern;

public class CSingleton {

    private static volatile CSingleton cSingleton = null;

    private CSingleton() {}

    public static CSingleton instanceOf() {
        if (null == cSingleton) {
            synchronized (CSingleton.class) {
                if(null == cSingleton) {
                    cSingleton = new CSingleton();
                }
            }
        }
        return cSingleton;
    }
}
