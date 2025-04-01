package languages.murasaki.MurasakiLanguages.infra.dtos.plans;

import java.math.BigDecimal;
import java.util.List;

public record PlansDto(String id, String title, String description, BigDecimal value, List<String> advantages) {
}
