package project.metrics.step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 数据采集  ->  存储  ->  聚合统计  ->  显示
 * 响应时间    内存、DB    max、min、avg  console、email、http、自定义
 * 访问时间    日志、文件   count、tps
 */
public class Metrics {
    // Key:接口名称 value: 对应接口请求的响应时间或时间戳
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 记录接口请求的响应时间
     *
     * @param apiName
     * @param responseTime
     */
    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    /**
     * 记录接口请求的访问时间
     *
     * @param apiName
     * @param timestamp
     */
    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    /**
     * 以指定的频率统计数据并输出结果
     *
     * @param period
     * @param unit
     */
    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Map<String, Map<String, Double>> stats = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiRespTimes = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("max", max(apiRespTimes));
                    stats.get(apiName).put("avg", avg(apiRespTimes));
                }

                for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiTimestamps = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("count", (double)apiTimestamps.size());
                }
            }
        }, 0, period, unit);
    }

    private Double max(List<Double> apiRespTimes) {
        return apiRespTimes.stream().max(Double::compare).get();
    }

    private Double avg(List<Double> apiRespTimes) {
        return apiRespTimes.stream().collect(Collectors.averagingDouble(Double::doubleValue));
    }


    public static void main(String[] args) throws Exception{
        Metrics metrics = new Metrics();
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);

        long startTimeStamp = System.currentTimeMillis();
        metrics.recordTimestamp("regsiter", startTimeStamp);
        // do something
        TimeUnit.SECONDS.sleep(1);
        long responTime = System.currentTimeMillis() - startTimeStamp;
        metrics.recordResponseTime("register", responTime);
    }
}
