package languages.murasaki.MurasakiLanguages.core.entities.plans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public record Plans(String id, String title, String description, BigDecimal value, List<String> advantages) implements Serializable {
}
