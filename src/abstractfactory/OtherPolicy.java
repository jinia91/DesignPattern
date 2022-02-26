package abstractfactory;

public interface OtherPolicy {

    default long calculate(Long price) {
        OtherRule rule = createOtherRule(price);
        return rule.calculateMaxOther(price);
    }

    OtherRule createOtherRule(Long price);
}
