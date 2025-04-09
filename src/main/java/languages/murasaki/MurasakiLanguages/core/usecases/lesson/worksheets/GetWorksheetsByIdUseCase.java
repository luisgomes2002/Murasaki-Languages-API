package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;

public interface GetWorksheetsByIdUseCase {

    Worksheets execute(String id);
}
