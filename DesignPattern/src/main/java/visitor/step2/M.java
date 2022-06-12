package visitor.step2;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.多态是一种动态绑定，在运行时获取对象的实际类型，运行实际类型对应的方法
 *   A a = new B(); B为A的子类。
 * 2.函数重载是一种静态绑定，编译时并不能获取对象的实际类型，而是根据声明类型执其所对应的方法
 *   重载函数: 在同一个类中函数名相同、参数不同的一组函数
 * 3.由于多态特性，sourceFile.extract2Txt(extractor); 方法会调用适合的重载函数，因为传入的是this对象
 * 4.但还有一个问题，如果继续扩展功能，违反开闭原则
 * @see PdfFile
 * @see WordFile
 */
public class M {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> sourceFiles = listAllResourceFiles("/filepath/");
        // 对不同类型文件进行数据抽取
        for (ResourceFile sourceFile : sourceFiles) {
            // 报错 由于函数重载在编译时不能确认具体的类型，所以编译时报错
            // extractor.extract2Txt(sourceFile);

            // 重点:
            // 由于多态特性，程序会调用实际类型的accept函数，比如PDF的accept函数，此时this类型是PdfFile，在编译时已经确定了，
            // 所以会调用extract2Txt(PdfFile pdfFile)这个重载函数。
            sourceFile.extract2Txt(extractor);
        }

        // 对不同类型文件进行文件压缩
        Compressor compressor = new Compressor();
        for (ResourceFile sourceFile : sourceFiles) {
            sourceFile.compress(compressor);
        }

    }

    private static List<ResourceFile> listAllResourceFiles(String resourcePath) {
        ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile(resourcePath + "a.pdf"));
        resourceFiles.add(new WordFile(resourcePath + "b.word"));
        return resourceFiles;
    }
}
