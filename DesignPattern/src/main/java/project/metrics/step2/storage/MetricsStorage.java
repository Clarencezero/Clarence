package project.metrics.step2.storage;

import project.metrics.step2.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 存储层接口定义
 */
public interface MetricsStorage {
    /**
     * 保存接口调用信息
     * @param requestInfo
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 获取某个范围内的接口调用详情
     * @param apiName
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, Long endTimeInMillis);

    /**
     * 获取某个时间范围内的接口调用详情
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, Long endTimeInMillis);
}
