package bridge.ver1_before;

public class CreditCardPaymentController {

    private final MasterCardPaymentService masterCardPaymentService = new MasterCardPaymentService();
    private final VisaCardPaymentService visaCardPaymentService = new VisaCardPaymentService();

    public String doPayment(String payMethod) {
        if(payMethod.equals("MASTER")){
            return masterCardPaymentService.doService();
        }
        if(payMethod.equals("VISA")){
            return visaCardPaymentService.doService();
        }
        throw new IllegalArgumentException("결제 지원 안함");
    }
}
