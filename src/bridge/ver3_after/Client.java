package bridge.ver3_after;

public class Client {

    static VisaCardPaymentService visaCardPaymentService = new VisaCardPaymentService();
    static UnionPayCardPaymentService unionPayCardPaymentService = new UnionPayCardPaymentService();
    static MasterCardPaymentService masterCardPaymentService = new MasterCardPaymentService();

    public static void main(String[] args) {
        ApplePayPaymentController paymentController = new ApplePayPaymentController(masterCardPaymentService);

        String client = paymentController.doPayment();
        // 기능부와 구현부를 각기 Hierarchy하게 구성하므로써, 기능의 변경과 구현의 변경이 독립적으로 이루어질 수 있고,
        // 기능부와 구현부 변경사항이 클라이언트에 전파되지도 않음
        // 구조적인 관점에서 클라이언트 - 인터페이스 - 전략알고리즘, 전략알고리즘을 사용하는 클라이언트(인터페이스)의 계층화라고 이해하자
        System.out.println("client = " + client);
        System.out.println(paymentController.applePayUniqueFeature());
    }

}
