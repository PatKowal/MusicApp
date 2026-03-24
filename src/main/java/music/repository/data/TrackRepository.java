package music.repository.data;

import music.model.Album;
import music.model.Artist;
import music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findAllByAlbumsContaining(Album album);

    List<Track> findAllByArtist(Artist artist);
}
