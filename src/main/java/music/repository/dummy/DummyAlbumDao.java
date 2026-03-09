package music.repository.dummy;

import music.model.Album;
import music.model.Track;
import music.repository.AlbumDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Primary
public class DummyAlbumDao implements AlbumDao {
    @Override
    public List<Album> findAll() {
        return List.of();
    }

    @Override
    public Album findById(int id) {
        return null;
    }

    @Override
    public List<Album> findByTrack(Track t) {
        return List.of();
    }
}
