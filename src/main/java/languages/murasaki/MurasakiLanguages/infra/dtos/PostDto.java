package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.entities.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto(String id, String titlePt, String titleEn, String textPT, String textEn, String banner, String userId, List<Integer> likes, List<Comment> commentList, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
