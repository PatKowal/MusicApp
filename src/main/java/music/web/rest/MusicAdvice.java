package music.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class MusicAdvice {
    private final AlbumValidator albumValidator;

    @InitBinder("album")
    void initBinder(WebDataBinder binder) { binder.addValidators(albumValidator); }
}
