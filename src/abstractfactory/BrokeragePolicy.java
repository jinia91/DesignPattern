package abstractfactory;

public interface BrokeragePolicy {

    default long calculate(Long price) {
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calculateMaxBrokerage(price);
    }

    BrokerageRule createBrokerageRule(Long price);
}
