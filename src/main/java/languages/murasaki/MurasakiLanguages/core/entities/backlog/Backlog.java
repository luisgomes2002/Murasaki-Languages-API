package languages.murasaki.MurasakiLanguages.core.entities.backlog;

import java.time.LocalDateTime;

public record Backlog(String id, String user, String description, LocalDateTime createdAt) {
}
