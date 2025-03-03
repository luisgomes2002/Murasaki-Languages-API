package languages.murasaki.MurasakiLanguages.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Comment(String message, String username, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comment> replies) {
}
