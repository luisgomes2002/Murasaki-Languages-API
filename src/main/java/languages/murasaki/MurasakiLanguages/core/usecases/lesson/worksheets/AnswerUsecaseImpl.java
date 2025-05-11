package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;

public class AnswerUsecaseImpl implements AnswerUsecase {

    private final WorksheetsGateway worksheetsGateway;

    public AnswerUsecaseImpl(WorksheetsGateway worksheetsGateway) {
        this.worksheetsGateway = worksheetsGateway;
    }

    @Override
    public String execute(Worksheets worksheets) {
        return worksheetsGateway.answerWorkSheet(worksheets);
    }
}
