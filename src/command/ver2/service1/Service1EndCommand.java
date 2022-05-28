package command.ver2.service1;

import command.ver2.ServiceCommand;

public class Service1EndCommand implements ServiceCommand {
    private final Service1 service1;

    public Service1EndCommand(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void doService() {
        service1.end();
    }

    @Override
    public void unDoService() {
        new Service1StartCommand(this.service1).doService();
    }
}
