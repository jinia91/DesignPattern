package command.ver2;

import command.ver2.ServiceCommand;

import java.util.Stack;

public class CommandExecutor {
    private final Stack<ServiceCommand> commandsHistory = new Stack<>();

    public void execute(ServiceCommand command){
        commandsHistory.push(command);
        command.doService();
    }

    public void revert(){
        ServiceCommand revertCommand = commandsHistory.pop();
        revertCommand.unDoService();
    }
}
