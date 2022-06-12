package visitor.step3;

/**
 * 文件抽取实现类
 *
 */
public class ExtractVisitor implements Visitor {
    /**
     * PDF文件抽取
     * @param pdfResourceFile
     */
    @Override
    public void visit(PdfResourceFile pdfResourceFile) {
        System.out.println("PDF EXTRACT.");
    }

    /**
     * word文件抽取
     * @param wordResourceFile
     */
    @Override
    public void visit(WordResourceFile wordResourceFile) {
        System.out.println("WORD EXTRACT.");
    }
}
