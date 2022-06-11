package interpreter.ver02.expression;

import interpreter.ver02.PostExpression;

import java.util.Map;

public class MinusExpression implements PostExpression {

    private PostExpression postNum, preNum;

    public MinusExpression(PostExpression postNum, PostExpression preNum) {
        this.postNum = postNum;
        this.preNum = preNum;
    }

    @Override
    public int interpret() {
        return preNum.interpret() - postNum.interpret();
    }
}
