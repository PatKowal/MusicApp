package music.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.model.Track;
import music.service.AlbumService;
import music.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AlbumController {
    private final AlbumService albumService;
    private final TrackService trackService;

    @GetMapping("/albums")
/*    String getAlbums(Model model) {
        log.info("Getting albums");
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "albumsView";
    }*/

    String getAlbums(Model model, @RequestParam(value = "trackId",  required = false) Integer trackId) {
        log.info("Getting albums with  track {}", trackId);
        if (trackId != null) {
            Track track = trackService.getTrackById(trackId);
            List<Album> albums = albumService.getAlbumsByTrack(track);
            model.addAttribute("albums", albums);
            model.addAttribute("title", "Albums with '" + track.getTitle() + "'");
        } else {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("title", "Albums");
        }
        return "albumsView";
    }
}
