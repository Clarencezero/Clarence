package visitor.step3;

/**
 * 访问者接口
 * 包含两个重载函数，分别处理两种不同类型的资源文件。具体选择哪个文件处理，需要在编译时进行绑定，
 * 在各个Resource实现内部，会把this传递给当前方法，这样就可以知道绑定的对象是哪个，选用合适的重载方法进行处理。
 * 具体做什么业务处理，由实现这个visitor接口的具体实现类来决定。
 *
 */
public interface Visitor {
    /**
     * 定义PDF类型
     * @param pdfResourceFile
     */
    void visit(PdfResourceFile pdfResourceFile);

    /**
     * 定义Word类型
     * @param wordResourceFile
     */
    void visit(WordResourceFile wordResourceFile);
}
