package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.UserAnswersLogEntity;
import org.springframework.stereotype.Component;

@Component
public class UserAnswersLogEntityMapper {

    public UserAnswersLogEntity toEntity(UserAnswersLog userAnswersLog){
        return new UserAnswersLogEntity(
          userAnswersLog.id(),
          userAnswersLog.userId(),
          userAnswersLog.answers()
        );
    }

    public UserAnswersLog toDomain(UserAnswersLogEntity userAnswersLog){
        return new UserAnswersLog(
          userAnswersLog.getUserId(),
          userAnswersLog.getUserId(),
          userAnswersLog.getAnswers()
        );
    }
}
