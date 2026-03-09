package music.web.rest;

import lombok.RequiredArgsConstructor;
import music.model.Album;
import music.service.AlbumService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AlbumValidator implements Validator {
    private final AlbumService albumService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(Album.class); }

    @Override
    public void validate(Object target, Errors errors) {
        Album validatedAlbum = (Album) target;
        boolean duplicated = albumService.getAllAlbums().stream()
                .anyMatch(album -> album.getName().equals(validatedAlbum.getName()));
        if (duplicated) {
            errors.rejectValue("name", "album.name.duplicated");
        }
    }
}
