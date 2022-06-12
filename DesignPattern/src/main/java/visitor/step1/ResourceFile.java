package visitor.step1;

/**
 * 抽象类，包含extract2Txt方法，所有不同类型的文件实现此方法进行转换
 */
public abstract class ResourceFile {
    // 资源路径
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    // 定义抽取动作
    public abstract void extract2Txt();
}
