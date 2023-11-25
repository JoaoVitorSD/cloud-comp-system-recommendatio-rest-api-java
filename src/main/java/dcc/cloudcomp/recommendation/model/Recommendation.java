package dcc.cloudcomp.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    private String playlist;
    private List<String> matchedTracks;
    private List<String> rule;
}
