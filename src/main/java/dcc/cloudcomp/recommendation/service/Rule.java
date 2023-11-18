package dcc.cloudcomp.recommendation.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rule implements Serializable {
    private List<String> tracks;
    private Double percentage;

    private List<String> playlists;

}
