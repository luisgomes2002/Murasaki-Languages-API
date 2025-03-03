package languages.murasaki.MurasakiLanguages.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Comments(String message, String username, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comments> replies) {
}
