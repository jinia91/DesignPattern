package factorymethod;

public interface BrokeragePolicyFactory {
    BrokeragePolicy of(ActionType actionType);
}
