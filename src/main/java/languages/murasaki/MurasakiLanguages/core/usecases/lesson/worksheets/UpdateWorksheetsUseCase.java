package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;

public interface UpdateWorksheetsUseCase {

    Worksheets execute(String id, Worksheets worksheets);
}
