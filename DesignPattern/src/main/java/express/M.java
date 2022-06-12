package main.java.express;

import java.util.HashMap;

/**
 * 解释器模式的代码比较灵活，没有固定的模板。核心思想是将语法解析的工作拆分到各个小类中，从而避免大而全的解析类。
 * 一般做法是，将语法规则拆分一些小的独立单元，然后对每个单元进行解析，最终合并为对整个语法规则的解析
 */
public class M {
    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 30 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        HashMap<String, Long> stats = new HashMap<>(6);
        stats.put("key1", 101L);
        stats.put("key3", 121L);
        stats.put("key4", 88L);

        boolean interpret = interpreter.interpret(stats);
        System.out.println("是否产生预警: " + (interpret ? "产生预警": "未能产生预警"));
    }
}
