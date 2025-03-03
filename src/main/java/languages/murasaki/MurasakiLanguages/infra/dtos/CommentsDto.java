package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.entities.Comments;

import java.time.LocalDateTime;
import java.util.List;

public record CommentsDto(String message, String username, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comments> replies){
}
