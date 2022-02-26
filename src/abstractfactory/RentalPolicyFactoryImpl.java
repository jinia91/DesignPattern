package abstractfactory;

public class RentalPolicyFactoryImpl implements PolicyAbstractFactory{
    @Override
    public BrokeragePolicy createBrokeragePolicy() {
        return new RentalBrokeragePolicy();
    }

    @Override
    public OtherPolicy createOtherPolicy() {
        return new RentalOtherPolicy();
    }
}
