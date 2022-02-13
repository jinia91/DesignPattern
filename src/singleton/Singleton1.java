package singleton;

public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1(){}

    static public Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
