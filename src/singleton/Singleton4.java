package singleton;

public class Singleton4 {

    static class InstanceHolder{
        private static Singleton4 instance = new Singleton4();
    }

    private Singleton4(){}

    static public Singleton4 getInstance(){
        return InstanceHolder.instance;
    }
}
