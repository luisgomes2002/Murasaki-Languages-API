package languages.murasaki.MurasakiLanguages.infra.dtos.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.course.Worksheets;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.time.LocalDateTime;
import java.util.List;

public record CourseDto(String id, String title, String text, List<Explanation> explanations, List<Worksheets> worksheets , List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published, Visibility visibility)  {
}