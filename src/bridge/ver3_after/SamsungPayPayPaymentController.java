package bridge.ver3_after;

public class SamsungPayPayPaymentController extends PaymentController{

    private final String USECASE = "삼성페이로";

    public SamsungPayPayPaymentController(PaymentService paymentService) {
        super(paymentService);
    }

    public String doPayment() {
        return USECASE + getPaymentService().doService();
    }

    public String applePayUniqueFeature(){
        return "삼성페이만의 유니크한 기능";
    }
}
