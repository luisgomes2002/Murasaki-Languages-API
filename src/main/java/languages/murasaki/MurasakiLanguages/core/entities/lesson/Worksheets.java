package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.io.Serializable;
import java.util.List;

public record Worksheets(String id, String question, List<String> options, String answer, String explanation) implements Serializable {
}
