package dcc.cloudcomp.recommendation.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dcc.cloudcomp.recommendation.model.Recomendation;
import dcc.cloudcomp.recommendation.model.RuleCompatibility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class Recommender {
    List<Rule> rules;


    public Recommender() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.json");
        ObjectMapper objectMapper = new ObjectMapper();
        this.rules = objectMapper.readValue(inputStream, new TypeReference<>(){});
    }


    public List<String> getRecommendation(List<String> tracks){
        Recomendation recomendation = new Recomendation();
        for (Rule rule : rules) {
            int commonTracks = 0;
            float compatibility = 0;
            for(String track : tracks){
                for(String trackRule : rule.getTracks()){
                    if(track.equals(trackRule)){
                        commonTracks++;
                    }
                }
            }
            compatibility = (float) commonTracks / rule.getTracks().size();
            recomendation.addRule(new RuleCompatibility(rule, compatibility));
        }
        return recomendation.getRecommentaions();
    }
}
