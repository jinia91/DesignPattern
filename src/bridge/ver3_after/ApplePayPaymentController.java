package bridge.ver3_after;

public class ApplePayPaymentController extends PaymentController{

    private final String USECASE = "애플페이로";

    public ApplePayPaymentController(PaymentService paymentService) {
        super(paymentService);
    }

    public String doPayment() {
        return USECASE + getPaymentService().doService();
    }

    public String applePayUniqueFeature(){
        return "애플페이만의 유니크한 기능";
    }
}
