package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;

import java.time.LocalDateTime;
import java.util.List;

public record CourseDto(String id, String title, String text, List<String> links, String username, LanguageType languageType, LocalDateTime createAt, LocalDateTime updatedAt){
}
