package languages.murasaki.MurasakiLanguages.core.entities.lessoncollection;

import java.io.Serializable;

public record LessonCollection(String id, String languageName, boolean status) implements Serializable {
}
