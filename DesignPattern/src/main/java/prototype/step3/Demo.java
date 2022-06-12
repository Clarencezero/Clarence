package prototype.step3;

import prototype.SearchWords;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现一: 遍历对象，重新创建新的对象达到目的
 * 实现二: 先将对象序列化，然后反序列化成新的对象。
 * 实现三: 先采用浅拷贝的方法创建对象，对于需要更新的对象，使用深度拷贝的方法创建一份新的对象，替换原来的老对象。
 */
public class Demo {
    private HashMap<String, SearchWords> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1L;

    public void refresh() {
        HashMap<String, SearchWords> newKeyWords = new HashMap<>();
        for (Map.Entry<String, SearchWords> e : currentKeyWords.entrySet()) {
            SearchWords searchWords = e.getValue();
            SearchWords newSearchWord = new SearchWords(searchWords.getKeyWorld(), searchWords.getLastUpdateTime());
            newKeyWords.put(e.getKey(), newSearchWord);
        }

        // 从数据库中取出更新时间>lastUpdateTime的数据，放到newKeyWord中
        List<SearchWords> toBeupdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWords searchWord : toBeupdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWords.containsKey(searchWord.getKeyWorld())) {
                SearchWords oldContent = newKeyWords.get(searchWord.getKeyWorld());
                oldContent.setLastUpdateTime(searchWord.getLastUpdateTime());

            } else {
                newKeyWords.put(searchWord.getKeyWorld(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdateTime;
        currentKeyWords = newKeyWords;
    }

    private List<SearchWords> getSearchWords(long lastUpdateTime) {
        // 从数据库中获取 更新时间 > lastUpdateTime的数据
        return null;
    }

    public Object deepCopy(Object object) throws Exception{
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bo);
        objectOutputStream.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
