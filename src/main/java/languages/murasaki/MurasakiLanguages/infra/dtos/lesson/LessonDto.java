package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.time.LocalDateTime;
import java.util.List;

public record LessonDto(String id, String title, String text, List<Explanation> explanations, List<Worksheets> worksheets , List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published, Visibility visibility)  {
}