package main.java.express;

import java.util.Map;

/**
 * 定义表达式解析模板
 */
public interface Expression {
    /**
     * 对状态进行判断
     * @param stats
     * @return
     */
    boolean interpret(Map<String, Long> stats);
}
