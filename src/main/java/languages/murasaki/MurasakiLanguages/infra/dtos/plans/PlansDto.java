package languages.murasaki.MurasakiLanguages.infra.dtos.plans;

import java.math.BigDecimal;
import java.util.List;

public record PlansDto(String id, String planId, String title, String description, BigDecimal value, List<String> advantages) {
}
