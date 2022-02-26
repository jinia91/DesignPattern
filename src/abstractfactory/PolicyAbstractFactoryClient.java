package abstractfactory;

public class PolicyAbstractFactoryClient {

    private PolicyAbstractFactory policyAbstractFactory;

    public PolicyAbstractFactoryClient(PolicyAbstractFactory policyAbstractFactory) {
        this.policyAbstractFactory = policyAbstractFactory;
    }

    public BrokeragePolicy createBrokeragePolicy(){
        return policyAbstractFactory.createBrokeragePolicy();
    }

    public OtherPolicy createOtherPolicy(){
        return policyAbstractFactory.createOtherPolicy();
    }
}
