package proxy.v3;

public class ServiceProxy extends Service {

    private final Service serviceOrigin;

    public ServiceProxy(Service serviceOrigin) {
        this.serviceOrigin = serviceOrigin;
    }

    @Override
    public void doService() {
        System.out.println("---------------log start :");
        serviceOrigin.doService();
        System.out.println("---------------log finish");
    }
}
