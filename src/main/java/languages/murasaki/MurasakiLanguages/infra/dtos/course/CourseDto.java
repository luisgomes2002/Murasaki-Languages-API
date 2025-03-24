package languages.murasaki.MurasakiLanguages.infra.dtos.course;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;

import java.time.LocalDateTime;
import java.util.List;

public record CourseDto(String id, String title, String text, List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt) {
}