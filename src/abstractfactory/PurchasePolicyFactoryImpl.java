package abstractfactory;

public class PurchasePolicyFactoryImpl implements PolicyAbstractFactory{
    @Override
    public BrokeragePolicy createBrokeragePolicy() {
        return new PurchaseBrokeragePolicy();
    }

    @Override
    public OtherPolicy createOtherPolicy() {
        return new PurchaseOtherPolicy();
    }
}
