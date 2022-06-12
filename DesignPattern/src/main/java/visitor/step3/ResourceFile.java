package visitor.step3;

/**
 * 资源抽象类
 */
public abstract class ResourceFile {
    protected String filePath;
    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 这里可以接收visitor的标准实现，具体功能由Visitor具体实现类决定。
     * 可以接收CompressorVisitor用来压缩文件、ExtractVisitor用来抽取文件内容，将来还会有索引文件建立等功能需求，只需要实现visitor接口即可。
     * 功能的实现
     * @param visitor
     */
    public abstract void accept(Visitor visitor);
}
