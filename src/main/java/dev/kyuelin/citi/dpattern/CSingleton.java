package dev.kyuelin.citi.dpattern;

public class CSingleton {

    private CSingleton() {}

    private static volatile CSingleton cSingleton = null;

    // option 1 - double locked
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

    // option 2 - nested class static
    private static class CSingletonNew {
        private static final CSingleton cSingleton = new CSingleton();
    }

    public static CSingleton instanceOf2() {
        return CSingletonNew.cSingleton;
    }
}
