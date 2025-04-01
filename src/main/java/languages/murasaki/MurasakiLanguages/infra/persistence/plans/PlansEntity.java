package languages.murasaki.MurasakiLanguages.infra.persistence.plans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "plans")
public class PlansEntity {

    @Id
    private String id;

    private String title;
    private String description;
    private BigDecimal value;
    private List<String> advantages;

    public PlansEntity() {
    }

    public PlansEntity(String id, String title, String description, BigDecimal value, List<String> advantages) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
        this.advantages = advantages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }
}
