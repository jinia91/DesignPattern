package singleton;

public class Singleton2 {

    private static final Singleton2 instance = new Singleton2();

    private Singleton2(){}

    static public Singleton2 getInstance(){
        return instance;
    }
}
