package music.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AlbumRest {
    private final AlbumService albumService;
    @GetMapping("/albums")
    List<Album> getAlbums() {
        log.info("about to get albums");
        List<Album> albums = albumService.getAllAlbums();
        log.info("{} albums found.", albums.size());
        return albums;
    }
}
