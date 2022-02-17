package factorymethod;

import static factorymethod.ActionType.PURCHASE;
import static factorymethod.ActionType.RENT;

public class Client {

    public static void main(String[] args) {
        orderAndCalculateBrokerageAmount(PURCHASE, 100_000_000L);
        orderAndCalculateBrokerageAmount(RENT, 500_000_000L);

    }

    private static void orderAndCalculateBrokerageAmount(ActionType actionType, long price) {
        SimpleBrokeragePolicyFactoryImpl brokeragePolicyFactory = new SimpleBrokeragePolicyFactoryImpl();
        BrokeragePolicy brokeragePolicy = brokeragePolicyFactory.of(actionType);
        long calculatedBrokerageAmount = brokeragePolicy.calculate(price);
        System.out.println("calculatedBrokerageAmount = " + calculatedBrokerageAmount);
    }
}
