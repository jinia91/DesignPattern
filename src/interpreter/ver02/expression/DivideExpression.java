package interpreter.ver02.expression;

import interpreter.ver02.PostExpression;

import java.util.Map;

public class DivideExpression implements PostExpression {

    private PostExpression postNum, preNum;

    public DivideExpression(PostExpression postNum, PostExpression preNum) {
        this.postNum = postNum;
        this.preNum = preNum;
    }

    @Override
    public int interpret() {
        return preNum.interpret() / postNum.interpret();
    }
}
