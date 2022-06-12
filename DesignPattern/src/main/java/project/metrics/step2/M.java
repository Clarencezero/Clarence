package project.metrics.step2;


import project.metrics.step2.storage.JvmMetricsStorage;

public class M {
    public static void main(String[] args) {
        JvmMetricsStorage jvmMetricsStorage = new JvmMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(jvmMetricsStorage);
        consoleReporter.startRepeatedReport(10, 60);

        MetricsController metricsController = new MetricsController(jvmMetricsStorage);
        metricsController.recordRequest(new RequestInfo("register", 123, 10234));
        metricsController.recordRequest(new RequestInfo("register", 223, 1134));
        metricsController.recordRequest(new RequestInfo("register", 323, 12234));
        metricsController.recordRequest(new RequestInfo("login", 23, 12343));
        metricsController.recordRequest(new RequestInfo("login", 1223, 14343));

    }
}
