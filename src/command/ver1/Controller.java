package command.ver1;

public class Controller {
    private final Service1 service1;
    private final Service2 service2;

    public Controller(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    // GetMapping
    public void doService(){
        service1.doIt();
    }

    // GetMapping
    public void doService2(){
        service2.doIt();
    }

}
