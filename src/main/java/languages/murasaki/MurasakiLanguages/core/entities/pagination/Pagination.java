package languages.murasaki.MurasakiLanguages.core.entities.pagination;

import java.io.Serializable;
import java.util.List;

public record Pagination<T>(List<T> content,
                         int totalPages,
                         long totalElements,
                         int size,
                         int page) implements Serializable {
}
