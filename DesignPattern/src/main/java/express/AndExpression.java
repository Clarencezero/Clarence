package main.java.express;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 解析 &&
 * AND的话，需要里面的每个表达式都要满足最后才输出true
 */
public class AndExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String strAndExpression) {
        String[] elements = strAndExpression.split("&&");
        for (String element : elements) {
            if (element.contains(">")) {
                expressions.add(new GreaterExpression(element));
            } else if (element.contains("<")) {
                expressions.add(new LessExpression(element));
            } else if (element.contains("==")) {
                expressions.add(new EqualsExpression(element));
            } else {
                throw new RuntimeException("Expression is invalid: " + strAndExpression);
            }
        }
    }

    public AndExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if (!expression.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
