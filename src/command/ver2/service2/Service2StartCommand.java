package command.ver2.service2;

import command.ver2.ServiceCommand;

public class Service2StartCommand implements ServiceCommand {
        private final Service2 service2;

    public Service2StartCommand(Service2 service2) {
        this.service2 = service2;
    }


    @Override
    public void doService() {
        service2.start();
    }

    @Override
    public void unDoService() {
        new Service2EndCommand(this.service2).doService();
    }
}
