package music.web.rest.dto;

import lombok.Data;
import music.model.Artist;

@Data
public class TrackDTO {
    private String title;
    private Artist artist;
    private int duration;
}
