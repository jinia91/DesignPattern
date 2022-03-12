package bridge.ver3_after;

public class MasterCardPaymentService implements PaymentService{
    public String doService() {
        return "마스터카드를 사용해 지불";
    }
}
