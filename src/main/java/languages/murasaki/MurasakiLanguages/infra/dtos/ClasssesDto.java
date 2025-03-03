package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.Enums.LanguageType;

import java.time.LocalDateTime;
import java.util.List;

public record ClasssesDto(String title, String text, List<String> links, String username, LanguageType languageType, LocalDateTime createAt, LocalDateTime updatedAt){
}
