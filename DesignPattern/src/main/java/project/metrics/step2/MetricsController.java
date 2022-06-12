package project.metrics.step2;


import project.metrics.step2.storage.MetricsStorage;

/**
 * 使用组合模式，当需要新的存储方式，只需要实现MetricsStorage即可，除了在组装类上有改动，其他接口函数调用地方都不需要改动，满足开闭原则
 */
public class MetricsController {
    private MetricsStorage metricsStorage;
    public MetricsController(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null ||requestInfo.getApiName() == null) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
