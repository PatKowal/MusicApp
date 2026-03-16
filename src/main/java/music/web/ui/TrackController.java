package music.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.model.Artist;
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
public class TrackController {
    private final AlbumService albumService;
    private final TrackService trackService;

    @GetMapping("/tracks")
    String getTracks(Model model,
                     @RequestParam(value = "albumId",  required = false) Integer albumId,
                     @RequestParam(value = "artistId", required = false) Integer artistId) {
        log.info("Getting tracks inside album {}", albumId);
        if (albumId != null) {
            Album album = albumService.getAlbumById(albumId);
            List<Track> tracks = albumService.getTracksInAlbum(album);
            model.addAttribute("tracks", tracks);
            model.addAttribute("title", "Tracks in album '" + album.getName() + "'");
        } else if (artistId != null) {
            Artist artist = trackService.getArtistById(artistId);
            List<Track> tracks = trackService.getTracksByArtist(artist);
            model.addAttribute("tracks", tracks);
            model.addAttribute("title", "Tracks by '" + artist.getLastName() + "'");
        } else {
            List<Track> tracks = trackService.getAllTracks();
            model.addAttribute("tracks", tracks);
            model.addAttribute("title", "Tracks");
        }
        return "tracksView";
    }
}
