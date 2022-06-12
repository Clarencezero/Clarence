package visitor.step3;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式（GoF）：允许一个或者多个操作应用到一组对象上，解耦操作和对象本身
 * 应用场景：一般来说，访问者模式针对的是一组类型不同的对象（PDF、Word...） ，虽然它们类型不同，但是拥有相同父类或实现相同接口。
 * 在不同的场景下，我们需要对这组对象进行一系列不相关的业务操作，但为了避免不断添加功能导致类（PdfResourceFile、WordResourceFile）不断膨胀，职责越来越不单一
 * 以及频繁地添加功能导致的频繁代码修改，我们使用访问者模式，将对象与操作解耦，将这些业务操作抽离出来，定义在独立的细分的访问者类（CompressorVisitor、ExtractVisitor）中
 */
public class M {
    public static void main(String[] args) {
        //
        Visitor compress = new CompressorVisitor();
        Visitor extractor = new ExtractVisitor();
        List<ResourceFile> sourceFiles = listAllResourceFiles("h");
        for (ResourceFile sourceFile : sourceFiles) {
            sourceFile.accept(compress);
        }

        for (ResourceFile sourceFile : sourceFiles) {
            sourceFile.accept(extractor);
        }

        // 索引文件
        IndexVisitor indexVisitor = new IndexVisitor();
        for (ResourceFile sourceFile : sourceFiles) {
            sourceFile.accept(indexVisitor);
        }

    }

    private static List<ResourceFile> listAllResourceFiles(String resourcePath) {
        ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfResourceFile("a.pdf"));
        resourceFiles.add(new WordResourceFile("b.word"));
        return resourceFiles;
    }
}
