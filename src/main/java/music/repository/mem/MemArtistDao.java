package music.repository.mem;

import music.model.Artist;
import music.repository.ArtistDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("artistDao")
public class MemArtistDao implements ArtistDao {
    @Override
    public List<Artist> findAll() {
        return SampleData.artists;
    }

    @Override
    public Artist findById(int id) {
        return SampleData.artists.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Artist add(Artist a) {
        int max = SampleData.artists.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        a.setId(++max);
        SampleData.artists.add(a);
        return a;
    }
}
