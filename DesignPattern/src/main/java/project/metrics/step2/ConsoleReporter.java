package project.metrics.step2;

import project.metrics.step2.storage.MetricsStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService scheduledExecutor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSecond, long durationInSecond) {
        scheduledExecutor.scheduleAtFixedRate(() -> {
            long durationInMill = durationInSecond * 1000;
            long endTimeMillis = System.currentTimeMillis();
            long startTimeInMills = endTimeMillis - durationInMill;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMills, endTimeMillis);
            Map<String, RequestStat> stats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                String apiName = entry.getKey();
                List<RequestInfo> requestInfosPerApi = entry.getValue();
                // 计算得到统计数据

                RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMill);
                stats.put(apiName, requestStat);
            }
            // 将统计数据显示到终端
            System.out.println("Time Span: [" + startTimeInMills + ", " + endTimeMillis + "]");
        }, 0, periodInSecond, TimeUnit.SECONDS);
    }
}
