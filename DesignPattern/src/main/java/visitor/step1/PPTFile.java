package visitor.step1;
/**
 * PPT抽取资源实现类
 */
public class PPTFile extends ResourceFile{

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2Txt() {
        System.out.println("PPT EXTRACT.文件路径: " + filePath);
    }
}
