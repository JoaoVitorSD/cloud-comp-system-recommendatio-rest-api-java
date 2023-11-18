package dcc.cloudcomp.recommendation.controller;

import dcc.cloudcomp.recommendation.service.Recommender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecomendationController {

    private Recommender recommender;


    public RecomendationController(Recommender recommender) {
        this.recommender = recommender;
    }

    @GetMapping
    public List<String> getRecommendation(@RequestParam List<String> tracks) {
        return recommender.getRecommendation(tracks);
    }
}
