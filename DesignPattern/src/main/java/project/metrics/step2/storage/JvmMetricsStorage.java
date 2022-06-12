package project.metrics.step2.storage;


import project.metrics.step2.RequestInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JVM缓存
 */
public class JvmMetricsStorage implements MetricsStorage {
    List<RequestInfo> dataList = new ArrayList<>();
    Map<String, List<RequestInfo>> mapList = new HashMap<>();
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        mapList.putIfAbsent(requestInfo.getApiName(), new ArrayList<>());
        mapList.get(requestInfo.getApiName()).add(requestInfo);
        dataList.add(requestInfo);
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, Long endTimeInMillis) {
        return dataList;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, Long endTimeInMillis) {
        return mapList;
    }
}
