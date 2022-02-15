package factorymethod;

public class BrokeragePolicyFactoryImpl implements BrokeragePolicyFactory {
    public BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            case RENT:
                return new RentalBrokeragePolicy();
            default:
                throw new IllegalArgumentException("No Valid Policy");
        }
    }
}
