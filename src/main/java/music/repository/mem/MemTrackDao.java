package music.repository.mem;

import music.model.Album;
import music.model.Track;
import music.model.Artist;
import org.springframework.stereotype.Component;
import music.repository.TrackDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("trackDao")
public class MemTrackDao implements TrackDao {
    @Override
    public List<Track> findAll() {
        return SampleData.tracks;
    }

    @Override
    public Track findById(int id) {
        return SampleData.tracks.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Track> findByArtist(Artist a) {
        return SampleData.tracks.stream().filter(m -> m.getArtist() == a).collect(Collectors.toList());
    }

    @Override
    public List<Track> findByAlbum(Album a) {
        return SampleData.tracks.stream().filter(m -> m.getAlbums().contains(a)).collect(Collectors.toList());
    }

    @Override
    public Track add(Track t) {
        int max = SampleData.tracks.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        t.setId(++max);
        SampleData.tracks.add(t);
        return t;
    }
}
