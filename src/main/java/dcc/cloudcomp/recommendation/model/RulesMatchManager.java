package dcc.cloudcomp.recommendation.model;

import dcc.cloudcomp.recommendation.service.Rule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class RulesMatchManager {
    List<RuleCompatibility> recommendationList;


    public RulesMatchManager(){
        this.recommendationList = new ArrayList<>();
    }


    public void addRule(RuleCompatibility rule){
        if(recommendationList.size() <= 10){
            recommendationList.add(rule);
            return;
        }

        int last = recommendationList.size() - 1;
        if(recommendationList.get(last).getCompatibility() < rule.getCompatibility()){
            recommendationList.remove(last);
            recommendationList.add(rule);
        }
        recommendationList.sort((o1, o2) -> Float.compare(o2.getCompatibility(), o1.getCompatibility()));
    }

    public  List<Recommendation> getRecommentaions(){
        List<Recommendation> recommendations = new ArrayList<>();
        List<String> playlistsAdded = new ArrayList<>();

        List<RuleCompatibility> rules = recommendationList;
        if(recommendationList.get(0).getCompatibility()!=0){
            rules =  rules.stream().filter(r -> r.getCompatibility()>0).toList();
        }

        int maxRecommendationsPossible = 0;
        for(RuleCompatibility r: rules){
            maxRecommendationsPossible+=r.getRule().getPlaylists().size();
        }
        while(recommendations.size()<=20&&recommendations.size()<=maxRecommendationsPossible ){
        for(RuleCompatibility rule: rules){
            for(String playlist:rule.getRule().getPlaylists()){
                if(!playlistsAdded.contains(playlist)){
                    playlistsAdded.add(playlist);
                    recommendations.add(new Recommendation(playlist, rule.getMatchedTracks()));
                    break;
                }
            }
            }
        }
        return recommendations;
    }

}
