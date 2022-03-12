package bridge.ver3_after;

public class CreditCardPaymentController extends PaymentController{

    private final String USECASE = "신용카드로";

    public CreditCardPaymentController(PaymentService paymentService) {
        super(paymentService);
    }

    public String doPayment() {
        return USECASE + getPaymentService().doService();
    }
}
