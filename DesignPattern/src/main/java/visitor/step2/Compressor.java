package visitor.step2;

/**
 * 定义 对不同类型文件 压缩操作
 */
public class Compressor {
    /**
     * 压缩PDF文件
     * @param pdfFile
     */
    public void compress(PdfFile pdfFile) {
        System.out.println("compress pdf");
    }

    /**
     * 压缩Word文件
     * @param wordFile
     */
    public void compress(WordFile wordFile) {
        System.out.println("compress word");
    }
}
