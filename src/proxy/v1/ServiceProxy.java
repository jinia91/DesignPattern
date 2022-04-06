package proxy.v1;

public class ServiceProxy extends Service {

    @Override
    public void doService() {
        System.out.println("---------------log start :");
        super.doService();
        System.out.println("---------------log finish");
    }
}
