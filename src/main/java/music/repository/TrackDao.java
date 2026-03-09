package music.repository;

import music.model.Track;
import music.model.Artist;
import music.model.Album;

import java.util.List;

public interface TrackDao {
    List<Track> findAll();
    Track findById(int id);
    List<Track> findByArtist(Artist a);
    List<Track> findByAlbum(Album a);

    Track add(Track t);
}
