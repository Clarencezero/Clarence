package visitor.step3;

/**
 * PDF资源实现类
 */
public class PdfResourceFile extends ResourceFile {
    public PdfResourceFile(String filePath) {
        super(filePath);
    }

    /**
     * 这里可以接收visitor的标准实现，具体功能由Visitor具体实现类决定。
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        // 重点。需要传入此时的对象，否则，visitor不晓得调用哪个重载方法
        visitor.visit(this);
    }
}
