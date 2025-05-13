package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.AnswerRequest;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.AnswerRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerRequestDtoMapper {

    public AnswerRequestDto toDto(AnswerRequest answerRequest){
        return new AnswerRequestDto(
                answerRequest.worksheets(),
                answerRequest.answer()
        );
    }

    public AnswerRequest toDomain(AnswerRequestDto answerRequestDto){
        return new AnswerRequest(
                answerRequestDto.worksheets(),
                answerRequestDto.answer()
        );
    }
}
