package proxy.v2;

public class ServiceProxy implements ServiceInterface {

    private final ServiceInterface serviceOrigin;

    public ServiceProxy(ServiceInterface serviceOrigin) {
        this.serviceOrigin = serviceOrigin;
    }

    @Override
    public void doService() {
        System.out.println("---------------log start :");
        serviceOrigin.doService();
        System.out.println("---------------log finish");
    }
}
