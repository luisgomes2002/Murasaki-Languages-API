package languages.murasaki.MurasakiLanguages.core.entities;


import java.time.LocalDateTime;
import java.util.List;

public record Post(String title, String text, String banner, String userId, List<Integer> likes, List<Comments> commentsList, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
