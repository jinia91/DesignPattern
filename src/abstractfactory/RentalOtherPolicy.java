package abstractfactory;

/*
* 임대일때 중개 수수료를 계산해주는 클래스
* */
public class RentalOtherPolicy implements OtherPolicy {

    public OtherRule createOtherRule(Long price) {
        OtherRule rule;
        if(price < 50_000_000){
            rule = new OtherRule(0.5,200_000L);
        } else if(price < 200_000_000){
            rule = new OtherRule(0.4,300_000L);
        } else if(price < 900_000_000){
            rule = new OtherRule(0.3,null);
        } else if(price < 1_200_000_000){
            rule = new OtherRule(0.4,null);
        } else if(price < 1_500_000_000){
            rule = new OtherRule(0.5,null);
        } else {
            rule = new OtherRule(0.6,null);
        }
        return rule;
    }

}
