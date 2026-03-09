package music.repository;

import music.model.Artist;

import java.util.List;

public interface ArtistDao {
    List<Artist> findAll();

    Artist findById(int id);

    Artist add(Artist a);
}
