package bridge.ver2_raw;

public class CreditCardPaymentController {

    private final MasterCardPaymentService masterCardPaymentService = new MasterCardPaymentService();
    private final VisaCardPaymentService visaCardPaymentService = new VisaCardPaymentService();
    private final UnionPayCardPaymentService unionPaymentService = new UnionPayCardPaymentService();
    private final String USECASE = "신용카드로";

    public String doPayment(String payMethod) {
        if(payMethod.equals("MASTER")){
            return USECASE + masterCardPaymentService.doService();
        }
        if(payMethod.equals("VISA")){
            return USECASE + visaCardPaymentService.doService();
        }
        if(payMethod.equals("UNION")){
            return USECASE + unionPaymentService.doService();
        }
        throw new IllegalArgumentException("결제 지원 안함");
    }
}
