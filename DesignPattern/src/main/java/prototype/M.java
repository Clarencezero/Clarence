package prototype;

public class M {
    public static void main(String[] args) throws Exception{
        SearchWords content = new SearchWords();
        content.keyWorld = "Java";
        content.updateTimeStamp = System.currentTimeMillis();
        content.referenceClass = new ReferenceClass();

        SearchWords clone = content.clone();
        System.out.println("验证克隆对象是否相等(==): " + content.equals(clone));
        System.out.println("获取克隆对象属性值: " + clone.toString());

        System.out.println("克隆对象内部引用是否相等(==):" + (content.referenceClass == clone.referenceClass));
    }
}
