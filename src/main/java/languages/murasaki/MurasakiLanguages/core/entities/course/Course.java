package languages.murasaki.MurasakiLanguages.core.entities.course;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;

import java.time.LocalDateTime;
import java.util.List;

public record Course(String id, String title, String text, List<Explanation> explanations, List<Worksheets> worksheets, List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published) {
}