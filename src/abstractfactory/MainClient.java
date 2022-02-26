package abstractfactory;


public class MainClient {

    public static void main(String[] args) {
        PolicyAbstractFactoryClient policyAbstractFactoryClient = new PolicyAbstractFactoryClient(new PurchasePolicyFactoryImpl());

        BrokeragePolicy purchaseBrokeragePolicy = policyAbstractFactoryClient.createBrokeragePolicy();
        OtherPolicy purchaseOtherPolicy = policyAbstractFactoryClient.createOtherPolicy();

    }
}
