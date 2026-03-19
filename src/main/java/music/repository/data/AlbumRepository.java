package music.repository.data;

import music.model.Album;
import music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findAllByNameContaining(String name);

    @Query("select a from Album a inner join a.tracks track where track =: track")
    List<Album> findAllByTrack(@Param("track") Track track);
}
