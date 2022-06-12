package prototype.step2;

import prototype.SearchWords;

import java.util.HashMap;
import java.util.List;

/**
 * 需求: 在任意时刻，缓存中只保存某一版本快照。
 * 实现:
 *  1.使用原型模式拷贝当前的内存数据。然后从数据库中只捞出新增或者有更新的关键词。
 *  2.通过使用Object的clone方法进行浅拷贝来实现原型模式。
 *  3.由于使用的是浅拷贝，就会导致有的是老版本，有的是新版本，无法满足currentKeyWords中的数据在任何时刻者是同一版本的。
 */
public class Demo {
    private HashMap<String, SearchWords> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1L;
    public void refresh() {
        HashMap<String, SearchWords> newKeyWords = (HashMap<String, SearchWords>) currentKeyWords.clone();

        List<SearchWords> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWords searchWords : toBeUpdatedSearchWords) {
            if (searchWords.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWords.getLastUpdateTime();
            }
            if (newKeyWords.containsKey(searchWords.getKeyWorld())) {
                SearchWords oldContent = newKeyWords.get(searchWords.getKeyWorld());
                oldContent.setLastUpdateTime(searchWords.getLastUpdateTime());

            } else {
                newKeyWords.put(searchWords.getKeyWorld(), searchWords);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeyWords = newKeyWords;
    }

    private List<SearchWords> getSearchWords(long lastUpdateTime) {
        // 从数据库中获取 更新时间 > lastUpdateTime的数据
        return null;
    }

}
