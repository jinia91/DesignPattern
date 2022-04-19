package proxy.v3;

public class Client {

    static private final Service service = new ServiceProxy(new Service());

    public static void main(String[] args) {
        service.doService();
    }
}
