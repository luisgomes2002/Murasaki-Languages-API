package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;

import java.util.List;

public interface GetPublicLessonsUsecase {

    Pagination<Lesson> execute(int page, int size);
}
