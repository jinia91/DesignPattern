package command.ver2.service1;

import command.ver2.ServiceCommand;

public class Service1StartCommand implements ServiceCommand {
        private final Service1 service1;

    public Service1StartCommand(Service1 service1) {
        this.service1 = service1;
    }


    @Override
    public void doService() {
        service1.start();
    }

    @Override
    public void unDoService() {
        new Service1EndCommand(this.service1).doService();
    }
}
