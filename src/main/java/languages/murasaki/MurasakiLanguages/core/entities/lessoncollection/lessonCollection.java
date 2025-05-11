package languages.murasaki.MurasakiLanguages.core.entities.lessoncollection;

import java.io.Serializable;
import java.util.List;

public record lessonCollection(String id, String languageName, List<String> lessonId) implements Serializable {
}
