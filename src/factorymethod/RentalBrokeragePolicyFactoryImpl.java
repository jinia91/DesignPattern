package factorymethod;

public class RentalBrokeragePolicyFactoryImpl implements BrokeragePolicyFactory {
    public BrokeragePolicy of(ActionType actionType){
        if(actionType.equals(ActionType.RENT)) {
            return new RentalBrokeragePolicy();
        }
        throw new IllegalArgumentException();
    }
}
