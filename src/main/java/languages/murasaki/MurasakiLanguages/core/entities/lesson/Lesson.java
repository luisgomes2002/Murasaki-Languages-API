package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record Lesson(String id, String title, String text, List<Explanation> explanations, List<Worksheets> worksheets, List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published, Visibility visibility) implements Serializable {
}

// TODO: trocar List<Explanation> explanations para id
// TODO: trocar List<Worksheets> worksheets para id