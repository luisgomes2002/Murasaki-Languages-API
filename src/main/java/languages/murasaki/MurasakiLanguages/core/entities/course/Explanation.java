package languages.murasaki.MurasakiLanguages.core.entities.course;

import java.io.Serializable;

public record Explanation(String phrase, String translation, String explanation) implements Serializable {
}
