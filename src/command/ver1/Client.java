package command.ver1;

public class Client {

    public static void main(String[] args) {
        Controller controller = new Controller(new Service1());
        controller.doService();
//        new Controller(new Service2());
    }
}
