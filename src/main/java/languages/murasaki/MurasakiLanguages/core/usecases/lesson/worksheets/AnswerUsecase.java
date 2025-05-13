package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

public interface AnswerUsecase {
    UserReportDetail execute(AnswerRequest answerRequest);
}
