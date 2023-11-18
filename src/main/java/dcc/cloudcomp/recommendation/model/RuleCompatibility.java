package dcc.cloudcomp.recommendation.model;

import dcc.cloudcomp.recommendation.service.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RuleCompatibility {
    private Rule rule;
    private float compatibility;
}
