package visitor.step1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.由于多态，根据对象的实际类型，来决定执行哪个方法
 * 2.如果需要添加对Word文档处理，只需要对M方法中的 listAllResourceFiles 需要修改，算符号开闭原则
 * 3.那功能扩展方面如何? ResourceFile只提供将PDF、PPT等格式文件抽取到TXT文本文件中，若需要进行功能扩展，如压缩文件、提取文件元信息、构建索引等一系列功能，
 *   需要在此接口或抽象类中添加抽象方法/接口，如 void compress(); 将会导致它们的实现类职责不单一、可读性、可维护性变差。所有的代码逻辑耦合到实现类中。
 *   变成大杂烩。
 */
public class M {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles("h");
        // 遍历
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.extract2Txt();
        }
    }

    /**
     * 获取路径下所有可执行抽取动作的文件类型，包含PDF、PPT
     * @param resourcePath 路径
     * @return 可执行抽取动作的资源类
     */
    private static List<ResourceFile> listAllResourceFiles(String resourcePath) {
        ArrayList<ResourceFile> resourceFiles = new ArrayList<>(2);
        resourceFiles.add(new PDFFile("/file/a.pdf"));
        resourceFiles.add(new PPTFile("/file/b.ppt"));
        return resourceFiles;
    }
}


