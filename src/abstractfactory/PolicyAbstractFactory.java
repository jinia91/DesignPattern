package abstractfactory;

public interface PolicyAbstractFactory {

    BrokeragePolicy createBrokeragePolicy();
    OtherPolicy createOtherPolicy();

}
