package languages.murasaki.MurasakiLanguages.infrastructure.dtos.CourseCollection;

import java.util.List;

public record CourseCollectionDto(String id, String languageName, List<String> coursesId) {
}
