package bridge.ver3_after;

public abstract class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void changePaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public abstract String doPayment();
}
