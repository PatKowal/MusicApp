package music.repository.data;

import lombok.RequiredArgsConstructor;
import music.model.Album;
import music.model.Track;
import music.repository.AlbumDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataAlbumDao implements AlbumDao {
    private final AlbumRepository repository;

    @Override
    public List<Album> findAll() { return repository.findAll(); }

    @Override
    public Album findById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public List<Album> findByTrack(Track t) { return repository.findAllByTrack(t); }

    @Override
    public Album save(Album album) { return repository.save(album); }
}
