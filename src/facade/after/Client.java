package facade.after;

public class Client {

    public static void main(String[] args) {
        ConverterFacade converterFacade = new ConverterFacade();
        converterFacade.convertVideo("New Video.ogg");
    }
}
