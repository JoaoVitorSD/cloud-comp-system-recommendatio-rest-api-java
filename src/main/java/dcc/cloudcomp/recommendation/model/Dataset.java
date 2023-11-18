package dcc.cloudcomp.recommendation.model;

import dcc.cloudcomp.recommendation.service.Rule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Dataset {
    List<Rule> recommendationList;

}
