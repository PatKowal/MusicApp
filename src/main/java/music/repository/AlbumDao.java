package music.repository;

import music.model.Album;
import music.model.Track;

import java.util.List;

public interface AlbumDao {
    List<Album> findAll();

    Album findById(int id);

    List<Album> findByTrack(Track t);

    Album save(Album album);
}
