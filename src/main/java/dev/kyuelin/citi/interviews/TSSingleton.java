package dev.kyuelin.citi.interviews;

public class TSSingleton {

    private TSSingleton() {}

    public static TSSingleton tsSingleton = new TSSingleton();

    public static TSSingleton getInstance() {
        return tsSingleton;
    }

    // enum implementation
}