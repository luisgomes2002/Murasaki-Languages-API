package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;

public interface WorksheetsGateway {

    Worksheets createWorksheets(Worksheets worksheets);
    Worksheets updateWorksheet(String id, Worksheets worksheets);
    Worksheets getWorksheetsById(String id);

    void deleteWorksheets(String id);
}
