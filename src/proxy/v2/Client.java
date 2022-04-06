package proxy.v2;

public class Client {

    static private ServiceInterface service = new ServiceProxy(new Service());

    public static void main(String[] args) {
        service.doService();
    }
}
