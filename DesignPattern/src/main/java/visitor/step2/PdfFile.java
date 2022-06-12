package visitor.step2;


/**
 * PDF资源实现类
 */
public class PdfFile extends ResourceFile{
    public PdfFile(String filePath) {
        super(filePath);
    }

    /**
     * 抽取PDF文件内容到文本文件方法实现
     * @param extractor
     */
    @Override
    public void extract2Txt(Extractor extractor) {
        extractor.extract2Txt(this);
    }

    /**
     * 压缩PDF文件方法实现
     * @param compressor
     */
    @Override
    public void compress(Compressor compressor) {
        compressor.compress(this);
    }
}
