package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.io.Serializable;
import java.util.List;

public record Worksheets(String lessonId, String question, List<String> options, String answer) implements Serializable {
}
