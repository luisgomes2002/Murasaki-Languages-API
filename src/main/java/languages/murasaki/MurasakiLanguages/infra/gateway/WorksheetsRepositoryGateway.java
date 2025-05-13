package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.AnswerRequestDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.WorksheetsEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.WorkSheetsRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.WorksheetsEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WorksheetsRepositoryGateway implements WorksheetsGateway {

    private final WorkSheetsRepository workSheetsRepository;
    private final WorksheetsEntityMapper worksheetsEntityMapper;

    public WorksheetsRepositoryGateway(WorkSheetsRepository workSheetsRepository, WorksheetsEntityMapper worksheetsEntityMapper) {
        this.workSheetsRepository = workSheetsRepository;
        this.worksheetsEntityMapper = worksheetsEntityMapper;
    }

    @Override
    public Worksheets createWorksheets(Worksheets worksheets) {
        WorksheetsEntity entity = worksheetsEntityMapper.toEntity(worksheets);
        workSheetsRepository.save(entity);

        return worksheetsEntityMapper.toDomain(entity);
    }

    @Override
    public Worksheets updateWorksheet(String id, Worksheets worksheets) {
        Optional<WorksheetsEntity> entity = workSheetsRepository.findById(id);

        if(entity.isPresent()){
            WorksheetsEntity updatedWork = entity.get();

            updatedWork.setQuestion(worksheets.question());
            updatedWork.setOptions(worksheets.options());
            updatedWork.setAnswer(worksheets.answer());
            updatedWork.setExplanation(worksheets.explanation());

            workSheetsRepository.save(updatedWork);

            return worksheetsEntityMapper.toDomain(updatedWork);
        }

        return null;
    }

    @Override
    @Cacheable(value = "lesson", key = "#id")
    public Worksheets getWorksheetsById(String id) {
        return workSheetsRepository.findById(id).map(worksheetsEntityMapper::toDomain).orElse(null);
    }

    @Override
    public void deleteWorksheets(String id) {
        workSheetsRepository.deleteById(id);
    }

    @Override
    public UserReportDetail answerWorkSheet(AnswerRequest answerRequest) {
        if(answerRequest.answer().equals(answerRequest.worksheets().answer()))
            return null;
        else
            return new UserReportDetail(answerRequest.worksheets().id(), answerRequest.worksheets().explanation());
    }

}
