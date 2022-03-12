package bridge.ver3_after;

public class UnionPayCardPaymentService implements PaymentService{
    public String doService() {
        return "유니온페이카드를 사용해 지불";
    }
}
