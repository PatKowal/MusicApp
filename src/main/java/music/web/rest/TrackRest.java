package music.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.model.Track;
import music.service.AlbumService;
import music.service.TrackService;
import music.web.rest.dto.TrackDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TrackRest {
    private final TrackService trackService;
    private final AlbumService albumService;

    @GetMapping("/tracks")
    List<Track> getTracks() {
        log.info("Getting tracks");
        List<Track> tracks = trackService.getAllTracks();
        log.info("{} tracks found", tracks.size());
        return tracks;
    }

    @GetMapping("/tracks/{id}")
    ResponseEntity<Track> getTrack(@PathVariable("id") int id) {
        log.info("Getting track {}", id);
        Track track = trackService.getTrackById(id);
        log.info("{} track found", track.getId());
        if(track != null) return ResponseEntity.ok(track);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/albums/{id}/tracks")
    ResponseEntity<List<Track>> getTracksInAlbum(@PathVariable("id") int albumId) {
        log.info("Getting tracks by album {}", albumId);
        Album album = albumService.getAlbumById(albumId);
        if (album == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Track> tracks = albumService.getTracksInAlbum(album);
            log.info("{} tracks found in album {}", tracks.size(), album.getName());
            return ResponseEntity.ok(tracks);
        }
    }

    @PostMapping("/tracks")
    ResponseEntity<?> addTrack(@RequestBody TrackDTO trackDTO) {
        log.info("Adding track {}", trackDTO);
        Track track = new Track();
        track.setTitle(trackDTO.getTitle());
        track.setArtist(trackService.getArtistById(trackDTO.getArtist().getId()));
        track.setDuration(trackDTO.getDuration());
        track = trackService.addTrack(track);
        log.info("Added track {}", track);
        return ResponseEntity
                //.status(HttpStatus.CREATED)
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + track.getId())
                        .build()
                        .toUri())
                .body(track);
    }
}
