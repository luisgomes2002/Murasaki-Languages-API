package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;

public class AnswerUsecaseImpl implements AnswerUsecase {

    private final WorksheetsGateway worksheetsGateway;

    public AnswerUsecaseImpl(WorksheetsGateway worksheetsGateway) {
        this.worksheetsGateway = worksheetsGateway;
    }

    @Override
    public UserReportDetail execute(AnswerRequest answerRequest) {

        if(answerRequest.answer().isEmpty()) throw new MissingArgumentsException("Escolha uma alternativa.");

        return worksheetsGateway.answerWorkSheet(answerRequest);
    }
}
