package dcc.cloudcomp.recommendation.model;

import dcc.cloudcomp.recommendation.service.Recommender;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Recomendation {
    List<RuleCompatibility> recommendationList;


    public Recomendation(){
        this.recommendationList = new ArrayList<>();
    }


    public void addRule(RuleCompatibility rule){
        if(recommendationList.size() <= 5){
            recommendationList.add(rule);
            return;
        }

        int last = recommendationList.size() - 1;
        if(recommendationList.get(last).getCompatibility() < rule.getCompatibility()){
            recommendationList.remove(last);
            recommendationList.add(rule);
        }
        recommendationList.add(rule);
        recommendationList.sort((o1, o2) -> Float.compare(o1.getCompatibility(), o2.getCompatibility()));
    }
}
