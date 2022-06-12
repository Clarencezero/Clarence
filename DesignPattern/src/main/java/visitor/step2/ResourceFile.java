package visitor.step2;

/**
 * 文件资源抽象类
 * 设计思路: 把抽取文本内容的操作，设计成了三个重载函数。(重载函数
 */
public abstract class ResourceFile {
    // 文件路径
    protected String filePath;
    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 将文件内容抽取到Txt中
     * @param extractor
     */
    public abstract void extract2Txt(Extractor extractor);

    /**
     * 将文件压缩
     * @param compressor
     */
    public abstract void compress(Compressor compressor);
}
