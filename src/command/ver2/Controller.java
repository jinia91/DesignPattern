package command.ver2;

import command.ver1.Service1;

import java.util.Stack;

public class Controller {
    private final Stack<ServiceCommand> commands = new Stack<>();

    public void handle(ServiceCommand command){
        commands.push(command);
        command.doService();
    }

    public void revert(ServiceCommand command){
        ServiceCommand revertCommand = commands.pop();
        revertCommand.unDoService();
    }

}
