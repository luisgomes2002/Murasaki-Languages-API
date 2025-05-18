package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.UserAnswersLogDto;
import org.springframework.stereotype.Component;

@Component
public class UserAnswersLogDtoMapper {

    public UserAnswersLogDto toDto(UserAnswersLog userAnswersLog){
        return new UserAnswersLogDto(
          userAnswersLog.id(),
          userAnswersLog.userId(),
          userAnswersLog.answers()
        );
    }

    public UserAnswersLog toDomain(UserAnswersLogDto userAnswersLogDto){
        return new UserAnswersLog(
          userAnswersLogDto.id(),
          userAnswersLogDto.userId(),
          userAnswersLogDto.answers()
        );
    }
}
