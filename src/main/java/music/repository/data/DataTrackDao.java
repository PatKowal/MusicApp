package music.repository.data;

import lombok.RequiredArgsConstructor;
import music.model.Album;
import music.model.Artist;
import music.model.Track;
import music.repository.TrackDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataTrackDao implements TrackDao {
    private final TrackRepository repository;

    @Override
    public List<Track> findAll() { return repository.findAll(); }

    @Override
    public Track findById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public List<Track> findByArtist(Artist a) { return repository.findAllByArtist(a);}

    @Override
    public List<Track> findByAlbum(Album a) { return repository.findAllByAlbumsContaining(a); }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Track add(Track t) { return repository.save(t); }
}
