package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswers;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

public interface WorksheetsGateway {

    Worksheets createWorksheets(Worksheets worksheets);
    Worksheets updateWorksheet(String id, Worksheets worksheets);
    Worksheets getWorksheetsById(String id);

    void deleteWorksheets(String id);

    UserReportDetail answerWorkSheet(AnswerRequest answerRequest);

}
