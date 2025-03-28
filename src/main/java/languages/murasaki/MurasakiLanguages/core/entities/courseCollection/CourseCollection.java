package languages.murasaki.MurasakiLanguages.core.entities.courseCollection;

import java.io.Serializable;
import java.util.List;

public record CourseCollection(String id, String languageName, List<String> coursesId) implements Serializable {
}
