package command.ver2;

import command.ver2.service1.Service1;
import command.ver2.service1.Service1EndCommand;
import command.ver2.service1.Service1StartCommand;
import command.ver2.service2.Service2;
import command.ver2.service2.Service2EndCommand;
import command.ver2.service2.Service2StartCommand;

public class Client {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Service1StartCommand c1 = new Service1StartCommand(new Service1());
        Service2StartCommand c2 = new Service2StartCommand(new Service2());
        Service1EndCommand c3 = new Service1EndCommand(new Service1());
        Service2EndCommand c4 = new Service2EndCommand(new Service2());
        controller.handle(c1);
        controller.handle(c2);
        controller.handle(c3);
        controller.handle(c4);

    }
}
