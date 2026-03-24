package music.repository.data;

import lombok.RequiredArgsConstructor;
import music.model.Artist;
import music.repository.ArtistDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataArtistDao implements ArtistDao {
    private final ArtistRepository repository;

    @Override
    public List<Artist> findAll() { return repository.findAll(); }

    @Override
    public Artist findById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public Artist add(Artist a) { return repository.save(a); }
}
