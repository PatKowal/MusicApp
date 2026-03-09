package music.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.model.Track;
import music.service.AlbumService;
import music.service.TrackService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class AlbumRest {
    private final AlbumService albumService;
    private final TrackService trackService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final AlbumValidator albumValidator;

//    @InitBinder
//    void initBinder(WebDataBinder binder) { binder.addValidators(albumValidator); }

    @GetMapping("/albums")
    List<Album> getAlbums(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {
        log.info("about to get album list");
        log.info("phrase: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some-cookie: {}", someCookie);
        List<Album> albums = albumService.getAllAlbums();
        log.info("{} albums found.", albums.size());
        return albums;
    }

    @GetMapping("/albums/{id}")
    ResponseEntity<Album> getAlbum(@PathVariable("id") int id) {
        log.info("about to get album by id: {}", id);
        Album album = albumService.getAlbumById(id);
        log.info("{} album found.", album.getId());
        if (album != null) {
            return ResponseEntity.status(200).body(album);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tracks/{id}/albums")
    ResponseEntity<List<Album>> getAlbumsByTrack(@PathVariable("id") int id) {
        log.info("about to get albums by track id: {}", id);
        Track track = trackService.getTrackById(id);

        if (track == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Album> albums = albumService.getAlbumsByTrack(track);
            log.info("{} albums found by track.", albums.size());
            return ResponseEntity.ok(albums);
        }
    }

    @PostMapping("/albums")
    ResponseEntity<?> addAlbum(@Validated @RequestBody Album album, Errors errors, HttpServletRequest request) {
        log.info("adding album: {}", album);

        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
//            Locale locale = new Locale("pl", "PL");
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(),new Object[0],locale))
                    .reduce("errors:\n", (accu, oe) -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }

        album = albumService.addAlbum(album);
        log.info("new album added: {}", album);
        return ResponseEntity.status(HttpStatus.CREATED).body(album);
    }
}
