package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.io.Serializable;

public record Explanation(String id, String phrase, String translation, String explanation) implements Serializable {
}
