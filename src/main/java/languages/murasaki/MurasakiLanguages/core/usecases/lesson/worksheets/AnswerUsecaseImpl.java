package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;

public class AnswerUsecaseImpl implements AnswerUsecase {

    private final WorksheetsGateway worksheetsGateway;

    public AnswerUsecaseImpl(WorksheetsGateway worksheetsGateway) {
        this.worksheetsGateway = worksheetsGateway;
    }

    @Override
    public UserReportDetail execute(AnswerRequest answerRequest) {
        return worksheetsGateway.answerWorkSheet(answerRequest);
    }
}
