package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;
import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;

import java.time.LocalDate;
import java.util.List;

public interface MetricsGateway {

    Metrics getMetricByDate(String date);

    void metricsUpdateUserAge(LocalDate age, int delta);
    void metricsCreateUser();
    void metricsActiveUsers(int delta);
    void metricsBanUser(int delta);
    void metricsDeletedUser();
    void metricsUpdateUserGender(String gender, int delta);
    void metricsByLanguage(String language, int delta);

    void addMetricsToList(LocalDate date);
    List<MetricsDate> getAllMetricsDate();
}
