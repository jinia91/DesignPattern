package command.ver1;

public class Controller {
    private final Service1 service1;

    public Controller(Service1 service1) {
        this.service1 = service1;
    }

    public void doService(){
        service1.doIt();
    }
}
