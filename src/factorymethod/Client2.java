package factorymethod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static factorymethod.ActionType.PURCHASE;
import static factorymethod.ActionType.RENT;

public class Client2 {
    static Map<ActionType, Supplier<BrokeragePolicyFactory>> createConcreteFactory;
    static {
        createConcreteFactory = new HashMap<>();
        createConcreteFactory.put(PURCHASE,PurchaseBrokeragePolicyFactoryImpl::new);
        createConcreteFactory.put(RENT,RentalBrokeragePolicyFactoryImpl::new);
    }

    public static void main(String[] args) {
        orderAndCalculateBrokerageAmount(PURCHASE, 100_000_000L);
        orderAndCalculateBrokerageAmount(RENT, 500_000_000L);
    }

    private static void orderAndCalculateBrokerageAmount(ActionType actionType, long price) {

        BrokeragePolicyFactory brokeragePolicyFactory = createConcreteFactory.get(actionType).get();
        BrokeragePolicy brokeragePolicy = brokeragePolicyFactory.of(actionType);
        long calculatedBrokerageAmount = brokeragePolicy.calculate(price);
        System.out.println("calculatedBrokerageAmount = " + calculatedBrokerageAmount);
    }

}
