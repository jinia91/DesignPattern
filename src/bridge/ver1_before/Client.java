package bridge.ver1_before;

public class Client {

    public static void main(String[] args) {
        CreditCardPaymentController creditCardPaymentController = new CreditCardPaymentController();

        String master = creditCardPaymentController.doPayment("MASTER");
        System.out.println("master = " + master);
        String visa = creditCardPaymentController.doPayment("VISA");
        System.out.println("visa = " + visa);
    }
}
