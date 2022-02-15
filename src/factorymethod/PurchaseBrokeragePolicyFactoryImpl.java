package factorymethod;

public class PurchaseBrokeragePolicyFactoryImpl implements BrokeragePolicyFactory {
    public PurchaseBrokeragePolicyFactoryImpl() {
    }

    public BrokeragePolicy of(ActionType actionType){
        if(actionType.equals(ActionType.PURCHASE)) {
            return new PurchaseBrokeragePolicy();
        }
        throw new IllegalArgumentException();
    }
}
