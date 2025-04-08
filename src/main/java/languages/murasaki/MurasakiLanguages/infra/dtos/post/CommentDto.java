package languages.murasaki.MurasakiLanguages.infra.dtos.post;

import languages.murasaki.MurasakiLanguages.core.entities.post.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record CommentDto(String id, String message, String username, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comment> replies){
}
