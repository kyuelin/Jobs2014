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

    // Initialization-on-demand holder idiom
    public static CSingleton getInstance() {
        return PrivateSingltonHolder.cSingleton;
    }

    private static class PrivateSingltonHolder {
        public static final CSingleton cSingleton = new CSingleton();
    }

    // eager
    private static final CSingleton cSingleton1 = new CSingleton();
    
    public static CSingleton getcSingleton() {
        return cSingleton1;
    }
}
