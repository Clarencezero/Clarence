package visitor.step3;

/**
 * Word资源实现类
 */
public class WordResourceFile extends ResourceFile {
    public WordResourceFile(String filePath) {
        super(filePath);
    }

    /**
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
