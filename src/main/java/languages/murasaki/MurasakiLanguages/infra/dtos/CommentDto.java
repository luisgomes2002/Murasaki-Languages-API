package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.entities.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record CommentDto(String message, String username, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comment> replies){
}
