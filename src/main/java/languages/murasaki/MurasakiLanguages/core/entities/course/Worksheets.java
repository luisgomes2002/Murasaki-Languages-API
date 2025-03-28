package languages.murasaki.MurasakiLanguages.core.entities.course;

import java.io.Serializable;
import java.util.List;

public record Worksheets(String courseId, String question, List<String> options, String answer) implements Serializable {
}
