package dcc.cloudcomp.recommendation.controller;

import dcc.cloudcomp.recommendation.model.Recommendation;
import dcc.cloudcomp.recommendation.service.RecommenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
@CrossOrigin
public class RecomendationController {

    private RecommenderService recommender;


    public RecomendationController(RecommenderService recommender) {
        this.recommender = recommender;
    }

    @PostMapping
    public List<Recommendation> getRecommendation(@RequestBody SongsRequest songs) {
        return recommender.getRecommendation(songs.getSongs());
    }
}
