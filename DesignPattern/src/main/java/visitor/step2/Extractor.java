package visitor.step2;

/**
 * 定义 对不同类型文件 抽取操作
 * 这个类对文件的抽取功能。但是由于需要对不同文件具有不同的实现方式，所以有多个方法重载
 *
 */
public class Extractor {

    /**
     * 抽取PDF类型文件至Txt中
     * @param pdfFile
     */
    public void extract2Txt(PdfFile pdfFile) {
        System.out.println("PDF EXTRACT.");
    }

    /**
     * 抽取Word类型文件至Txt中
     * @param wordFile
     */
    public void extract2Txt(WordFile wordFile) {
        System.out.println("WORD EXTRACT.");
    }
}
