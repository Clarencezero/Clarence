package chainofresponsibility.sensitivewordfilter;


/**
 * 敏感词过滤二
 */
public class PoliticalWorldFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(Content content) {
        if (content.content.contains("政治")) {
            return false;
        }
        return true;
    }
}
