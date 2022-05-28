package command.ver2.service2;

import command.ver2.ServiceCommand;

public class Service2EndCommand implements ServiceCommand {
    private final Service2 service2;

    public Service2EndCommand(Service2 service2) {
        this.service2 = service2;
    }

    @Override
    public void doService() {
        service2.end();
    }

    @Override
    public void unDoService() {
        new Service2StartCommand(this.service2).doService();
    }
}
