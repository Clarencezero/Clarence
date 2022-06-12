package chainofresponsibility.sensitivewordfilter;


/**
 * 敏感词过滤一
 */
public class SexyWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(Content content) {
        if (content.content.contains("性")) {
            return false;
        }
        return true;
    }
}
