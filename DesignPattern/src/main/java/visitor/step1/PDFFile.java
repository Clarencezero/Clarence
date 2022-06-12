package visitor.step1;

/**
 * PDF抽取资源实现类
 */
public class PDFFile extends ResourceFile{
    public PDFFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2Txt() {
        System.out.println("PDF EXTRACT.文件路径: " + filePath);
    }
}
