package proxy.v1;

public class Client {

    static private Service service = new ServiceProxy();

    public static void main(String[] args) {
        service.doService();
    }
}
