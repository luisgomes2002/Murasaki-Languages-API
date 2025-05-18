package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.QuestionEligibility;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswers;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;
import languages.murasaki.MurasakiLanguages.core.gateway.UserAnswerGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.UserAnswersLogEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.UserAnswersLogEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.UserAnswersLogRepository;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserAnswerRepositoryGateway implements UserAnswerGateway {

    private final UserAnswersLogRepository userAnswersLogRepository;
    private final UserAnswersLogEntityMapper userAnswersLogEntityMapper;

    public UserAnswerRepositoryGateway(UserAnswersLogRepository userAnswersLogRepository, UserAnswersLogEntityMapper userAnswersLogEntityMapper) {
        this.userAnswersLogRepository = userAnswersLogRepository;
        this.userAnswersLogEntityMapper = userAnswersLogEntityMapper;
    }

    @Override
    public QuestionEligibility canAnswerQuestion(String userId, String questionId) {
        Optional<UserAnswersLogEntity> userLog = userAnswersLogRepository.findUserAnswersLogByUserId(userId);

        if (userLog.isEmpty()) {
            return new QuestionEligibility(true, "Você ainda não respondeu a esta pergunta. Pode responder agora.");
        }

        Optional<LocalDateTime> lastAnsweredOpt = userLog.get().getAnswers().stream()
                .filter(ans -> ans.questionId().equals(questionId))
                .map(UserAnswers::answeredAt)
                .max(LocalDateTime::compareTo);

        if (lastAnsweredOpt.isEmpty()) {
            return new QuestionEligibility(true, "Você ainda não respondeu a esta pergunta. Pode responder agora.");
        }

        LocalDateTime lastAnswered = lastAnsweredOpt.get();
        LocalDateTime nextAvailableTime = lastAnswered.plusDays(7);
        LocalDateTime now = LocalDateTime.now();

        if (now.isAfter(nextAvailableTime)) {
            return new QuestionEligibility(true, "Você pode responder a esta pergunta novamente.");
        } else {
            Duration duration = Duration.between(now, nextAvailableTime);
            long days = duration.toDays();
            long hours = duration.toHoursPart();
            long minutes = duration.toMinutesPart();

            String timeLeft = String.format("%d dias, %d horas e %d minutos", days, hours, minutes);
            String message = "Você ainda não pode responder a esta pergunta. Tente novamente em " + timeLeft + ".";
            return new QuestionEligibility(false, message);
        }
    }


    @Override
    public void saveQuestions(String userId, String questionId, String answer) {
        UserAnswers newUserAnswer = new UserAnswers(questionId, answer, LocalDateTime.now());

        UserAnswersLogEntity userLog = userAnswersLogRepository
                .findUserAnswersLogByUserId(userId)
                .orElseGet(() -> {
                    UserAnswersLogEntity newEntity = new UserAnswersLogEntity();
                    newEntity.setUserId(userId);
                    return newEntity;
                });

        List<UserAnswers> answers = userLog.getAnswers();

        Optional<UserAnswers> existingAnswerOpt = answers.stream()
                .filter(existing -> existing.questionId().equals(questionId))
                .findFirst();

        if (existingAnswerOpt.isPresent()) answers.remove(existingAnswerOpt.get());

        answers.add(newUserAnswer);

        userAnswersLogRepository.save(userLog);
    }


}
