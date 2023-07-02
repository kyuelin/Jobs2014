package dev.kyuelin.citi.mthread;

public class MTVolatile {

    // https://stackoverflow.com/questions/9328252/why-can-an-object-member-variable-not-be-both-final-and-volatile-in-java
    // private final volatile String myvolatile;

    private final String myvolatile;

    public MTVolatile(String myvolatile) {
        this.myvolatile = myvolatile;
    }
}
