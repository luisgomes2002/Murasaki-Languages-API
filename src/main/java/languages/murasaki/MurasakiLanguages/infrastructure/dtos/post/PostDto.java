package languages.murasaki.MurasakiLanguages.infrastructure.dtos.post;

import languages.murasaki.MurasakiLanguages.core.entities.post.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto(String id, String titlePt, String titleEn, String textPT, String textEn, String banner, String userId, List<Integer> likes, List<Comment> commentList, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
