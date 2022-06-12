package visitor.step3;


/**
 * 定义压缩功能访问者实现类
 *
 */
public class CompressorVisitor implements Visitor{
    /**
     * PDF类型压缩
     * @param pdfResourceFile
     */
    @Override
    public void visit(PdfResourceFile pdfResourceFile) {
        System.out.println("compress pdf");
    }

    /**
     * Word类型压缩
     * @param wordResourceFile
     */
    @Override
    public void visit(WordResourceFile wordResourceFile) {
        System.out.println("compress word");
    }
}
