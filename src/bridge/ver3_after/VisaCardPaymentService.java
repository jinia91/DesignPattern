package bridge.ver3_after;

public class VisaCardPaymentService implements PaymentService {
    public String doService() {
        return "비자카드를 사용해 지불";
    }
}
