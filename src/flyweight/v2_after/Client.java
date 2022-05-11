package flyweight.v2_after;

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Font goongsea = fontFactory.getFont("궁서");
        new Character('h', "blue", goongsea);
        new Character('e', "blue", goongsea);
        new Character('l', "blue", goongsea);
        new Character('l', "blue", goongsea);
        new Character('o', "blue", goongsea);
    }
}
