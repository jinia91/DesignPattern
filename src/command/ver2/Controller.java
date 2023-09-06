package command.ver2;

import command.ver2.service1.Service1;
import command.ver2.service1.Service1EndCommand;
import command.ver2.service1.Service1StartCommand;
import command.ver2.service2.Service2;
import command.ver2.service2.Service2EndCommand;
import command.ver2.service2.Service2StartCommand;

public class Controller {
    final CommandExecutor commandExecutor = new CommandExecutor();
    final Service1 service1 = new Service1();
    final Service2 service2 = new Service2();

    public void startService1(){
        commandExecutor.execute(new Service1StartCommand(service1));
    }

    public void endService1(){
        commandExecutor.execute(new Service1EndCommand(service1));
    }

    public void startService2(){
        commandExecutor.execute(new Service2StartCommand(service2));
    }

    public void endService2(){
        commandExecutor.execute(new Service2EndCommand(service2));
    }

    public void cancelLastService(){
        commandExecutor.revert();
    }
}
