package prototype.step1;


import prototype.SearchWords;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 需求: 数据库中存储大约10W条搜索关键字信息，每条信息包含 关键词、关键词被搜索次数、信息最近被更新的时间等。系统A在启动的时候会加载这份数据到内存中，用于处理某些其他的业务需求。
 *      不过，另外一个系统B，专门负责用来分析搜索日志，定时更新数据库中的数据，并且标记为新的数据版本。
 * 思路:
 *      只需要在系统A中，记录当前数据的版本Va对应的更新时间Ta，从数据库中捞出更新时间大于Ta的所有搜索关键词，然后针对差集中的每个关键词进行处理。如果已存在，则更新时间等信息。如果不存在，则加入相应的散列表中。
 * 不足:
 *      各个版本之间存在版本之间的依赖。某一时刻，系统中存在版本A和版本B。
 */
public class Demo {
    private ConcurrentHashMap<String, SearchWords> currentContent = new ConcurrentHashMap<>();
    private long lastUpdateTime = -1L;

    public void refresh() {
        // 从数据库中取出 更新时间>lastupdatetime的数据，放入到currentContent中
        List<SearchWords> toBeUpdatedSearchWords = getSearchContent(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;

        // 遍历数据库取出数据
        for (SearchWords searchWords : toBeUpdatedSearchWords) {
            // 如果超过当前快照时间，更新
            if (searchWords.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWords.getLastUpdateTime();
            }
            if (currentContent.containsKey(searchWords.getKeyWorld())) {
                currentContent.replace(searchWords.getKeyWorld(), searchWords);
            } else {
                currentContent.put(searchWords.getKeyWorld(), searchWords);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWords> getSearchContent(long lastUpdateTime) {
        List<SearchWords> dataList = new ArrayList<>();
        SearchWords content = new SearchWords();
        content.setKeyWorld("H");
        content.setLastUpdateTime(System.currentTimeMillis());
        dataList.add(content);
        return dataList;
    }

}
