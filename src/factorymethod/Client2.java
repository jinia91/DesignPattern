package factorymethod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static factorymethod.ActionType.PURCHASE;
import static factorymethod.ActionType.RENT;

public class Client2 {
    static Map<ActionType, BrokeragePolicyFactory> createConcreteFactory;
    static {
        createConcreteFactory = new HashMap<>();
        createConcreteFactory.put(PURCHASE,new PurchaseBrokeragePolicyFactoryImpl());
        createConcreteFactory.put(RENT,new RentalBrokeragePolicyFactoryImpl());
    }

    public static void main(String[] args) {
        orderAndCalculateBrokerageAmount(PURCHASE, 100_000_000L);
        orderAndCalculateBrokerageAmount(RENT, 500_000_000L);
    }

    private static void orderAndCalculateBrokerageAmount(ActionType actionType, long price) {

        BrokeragePolicyFactory brokeragePolicyFactory = createConcreteFactory.get(actionType);
        BrokeragePolicy brokeragePolicy = brokeragePolicyFactory.of(actionType);
        long calculatedBrokerageAmount = brokeragePolicy.calculate(price);
        System.out.println("calculatedBrokerageAmount = " + calculatedBrokerageAmount);
    }

}
