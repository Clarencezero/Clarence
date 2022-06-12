package chainofresponsibility.sensitivewordfilter;

/**
 * 1. 职责链模式很好体现单一职责原则。业务逻辑判断 设计成独立的类，通过接口方便扩展。
 * 2. 职责链模式也体现开闭原则。如果需要新添加过滤算法，我们只需要实现Filter接口，并通过addWordFitler添加到职责链即可。其它代码不需要修改，进而提高代码的扩展性。
 */
public class M {
    public static void main(String[] args) {
        SenstiveWordFilterChain senstiveWordFilterChain = new SenstiveWordFilterChain();
        senstiveWordFilterChain.addWordFilter(new PoliticalWorldFilter());
        senstiveWordFilterChain.addWordFilter(new SexyWordFilter());
        Content content = new Content();
        content.content = "2333";
        boolean filter = senstiveWordFilterChain.filter(content);
        if (filter) {
            System.out.println("可以正常发布");
        } else {
            System.out.println("不允许发布。因为包含敏感信息!");
        }
    }
}
