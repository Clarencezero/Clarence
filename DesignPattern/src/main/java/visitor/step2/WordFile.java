package visitor.step2;

/**
 * Word资源实现类
 */
public class WordFile extends ResourceFile{
    public WordFile(String filePath) {
        super(filePath);
    }

    /**
     * 抽取Word文件内容到文本文件方法实现
     * @param extractor
     */
    @Override
    public void extract2Txt(Extractor extractor) {
        extractor.extract2Txt(this);
    }

    /**
     * 压缩Word文件方法实现
     * @param compressor
     */
    @Override
    public void compress(Compressor compressor) {
        compressor.compress(this);
    }
}
