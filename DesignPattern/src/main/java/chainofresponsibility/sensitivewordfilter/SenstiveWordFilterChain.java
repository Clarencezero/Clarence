package chainofresponsibility.sensitivewordfilter;


import java.util.ArrayList;
import java.util.List;

/**
 * 通过集合保存过滤算法
 * 暴露filter执行敏感词过滤
 */
public class SenstiveWordFilterChain {
    private List<SensitiveWordFilter> filterList = new ArrayList<>();
    public void addWordFilter(SensitiveWordFilter filter) {
        this.filterList.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter sensitiveWordFilter : filterList) {
            if (!sensitiveWordFilter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
