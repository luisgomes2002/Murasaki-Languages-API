package languages.murasaki.MurasakiLanguages.core.entities;


import java.time.LocalDateTime;
import java.util.List;

public record Post(String id, String titlePt, String titleEn, String textPT, String textEn, String banner, String userId, List<Integer> likes, List<Comment> commentList, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
