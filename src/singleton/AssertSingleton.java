package singleton;

public class AssertSingleton {

    public static void main(String[] args) {
        assertSingleton1();
        assertSingleton2();
        assertSingleton3();
        assertSingleton4();
        assertSingleton5();
    }

    private static void assertSingleton1() {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();

        System.out.println(instance == instance2);
    }
    private static void assertSingleton2() {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();

        System.out.println(instance == instance2);
    }
    private static void assertSingleton3() {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();

        System.out.println(instance == instance2);
    }
    private static void assertSingleton4() {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();

        System.out.println(instance == instance2);
    }
    private static void assertSingleton5() {
        Singleton5 instance = Singleton5.iNSTANCE;
        Singleton5 instance2 = Singleton5.iNSTANCE;

        System.out.println(instance == instance2);
    }
}
