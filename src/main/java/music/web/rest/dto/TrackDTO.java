package music.web.rest.dto;

import lombok.Data;

@Data
public class TrackDTO {
    private String title;
    private Integer artistId;
    private int duration;
}
