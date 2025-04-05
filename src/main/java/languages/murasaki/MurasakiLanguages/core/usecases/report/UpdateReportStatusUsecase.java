package languages.murasaki.MurasakiLanguages.core.usecases.report;

public interface UpdateReportStatusUsecase {

    void execute(String id, boolean finished);
}
