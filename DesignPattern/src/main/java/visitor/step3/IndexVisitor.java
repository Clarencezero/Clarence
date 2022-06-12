package visitor.step3;

/**
 * 功能扩展一：建立索引文件
 */
public class IndexVisitor implements Visitor{
    @Override
    public void visit(PdfResourceFile pdfResourceFile) {
        System.out.println("对PDF建立索引");
    }

    @Override
    public void visit(WordResourceFile wordResourceFile) {
        System.out.println("对Word建立索引");
    }
}
