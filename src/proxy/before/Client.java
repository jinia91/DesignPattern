package proxy.before;

public class Client {

    static private Service service = new Service();

    public static void main(String[] args) {
        service.doService();
    }
}
