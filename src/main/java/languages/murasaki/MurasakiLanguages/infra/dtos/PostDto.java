package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.entities.Comments;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto(String title, String text, String banner, String userId, List<Integer> likes, List<Comments> commentsList, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
