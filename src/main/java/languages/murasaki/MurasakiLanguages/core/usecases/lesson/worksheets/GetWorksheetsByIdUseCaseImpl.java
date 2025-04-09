package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;

public class GetWorksheetsByIdUseCaseImpl implements GetWorksheetsByIdUseCase{

    private final WorksheetsGateway worksheetsGateway;

    public GetWorksheetsByIdUseCaseImpl(WorksheetsGateway worksheetsGateway) {
        this.worksheetsGateway = worksheetsGateway;
    }

    @Override
    public Worksheets execute(String id) {
        return worksheetsGateway.getWorksheetsById(id);
    }
}
