package abstractfactory;


/*
    가격이 특정 범위일때 상한 효율과 상한 금액을 가지는 클래스
*/
public class BrokerageRule {
    private Double brokeragePercentage;
    private Long limitAmount;

    public Long calculateMaxBrokerage(Long price){
        if(limitAmount == null){
          return multiplyPercent(price);
        }
        return Math.max(multiplyPercent(price),limitAmount);
    }

    public Long multiplyPercent(Long price){
        return Double.valueOf(Math.floor(brokeragePercentage / 100 * price)).longValue();
    }

    public BrokerageRule(Double brokeragePercentage, Long limitAmount) {
        this.brokeragePercentage = brokeragePercentage;
        this.limitAmount = limitAmount;
    }
}
