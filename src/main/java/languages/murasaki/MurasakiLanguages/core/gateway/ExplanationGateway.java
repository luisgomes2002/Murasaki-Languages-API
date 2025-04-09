package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;

import java.util.List;

public interface ExplanationGateway {

    Explanation createExplanation(Explanation explanation);
    Explanation updateExplanation(String id, Explanation explanation);
    Explanation getExplanationById(String id);

    void deleteExplanation(String id);

}
