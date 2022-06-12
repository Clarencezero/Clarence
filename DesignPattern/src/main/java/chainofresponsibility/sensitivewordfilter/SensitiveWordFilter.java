package chainofresponsibility.sensitivewordfilter;


public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
