package languages.murasaki.MurasakiLanguages.core.entities.post;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record Comment(String id, String message, String username, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comment> replies) implements Serializable {
}
