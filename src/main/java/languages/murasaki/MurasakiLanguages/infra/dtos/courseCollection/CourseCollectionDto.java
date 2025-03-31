package languages.murasaki.MurasakiLanguages.infra.dtos.courseCollection;

import java.util.List;

public record CourseCollectionDto(String id, String languageName, List<String> coursesId) {
}
