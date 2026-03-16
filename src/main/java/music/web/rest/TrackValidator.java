package music.web.rest;

import lombok.RequiredArgsConstructor;
import music.model.Artist;
import music.service.TrackService;
import music.web.rest.dto.TrackDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
public class TrackValidator implements Validator {
    private final TrackService trackService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(TrackDTO.class); }

    @Override
    public void validate(Object target, Errors errors) {
        TrackDTO trackDTO = (TrackDTO) target;
        Artist artist = trackService.getArtistById(trackDTO.getArtistId());
        if (artist == null) {
            errors.rejectValue("artistId", "artist.notFound");
        }
    }
}
