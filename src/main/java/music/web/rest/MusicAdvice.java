package music.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "music.web.rest")
@RequiredArgsConstructor
@Slf4j
public class MusicAdvice {
    private final AlbumValidator albumValidator;
    private final TrackValidator trackValidator;

    @InitBinder("album")
    void initBinderForAlbum(WebDataBinder binder) { binder.addValidators(albumValidator); }

    @InitBinder("trackDTO")
    void initBinderForTrack(WebDataBinder binder) { binder.addValidators(trackValidator); }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("illegal argument exception", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }
}
