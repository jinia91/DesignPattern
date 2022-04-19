package proxy.v2;

public class Client {

    static private final ServiceInterface service = new ServiceProxy(new Service());

    public static void main(String[] args) {
        service.doService();
    }
}
