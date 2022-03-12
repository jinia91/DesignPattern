package bridge.ver2_raw;

public class Client {

    public static void main(String[] args) {
        CreditCardPaymentController creditCardPaymentController = new CreditCardPaymentController();
        SamsungPayPayPaymentController samsungPayPayPaymentController = new SamsungPayPayPaymentController();
        ApplePayPaymentController applePayPaymentController = new ApplePayPaymentController();

        String client1 = creditCardPaymentController.doPayment("MASTER");
        System.out.println("client1 = " + client1);
        String client2 = creditCardPaymentController.doPayment("VISA");
        System.out.println("client2 = " + client2);
        String client3 = samsungPayPayPaymentController.doPayment("VISA");
        System.out.println("client3 = " + client3);
        String client4 = applePayPaymentController.doPayment("UNION");
        System.out.println("client4 = " + client4);
    }
}
