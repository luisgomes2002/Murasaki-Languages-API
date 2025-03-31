package languages.murasaki.MurasakiLanguages.infra.dtos.backlog;

import java.time.LocalDateTime;

public record BacklogDto(String id, String user, String description, LocalDateTime createdAt) {
}
