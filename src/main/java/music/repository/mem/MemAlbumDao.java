package music.repository.mem;

import music.model.Album;
import music.model.Track;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import music.repository.AlbumDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("albumDao")
public class MemAlbumDao implements AlbumDao {
    @Override
    public List<Album> findAll() { return SampleData.albums; }

    @Override
    public Album findById(int id) { return SampleData.albums.stream().filter(c -> c.getId() == id).findFirst().orElse(null); }

    @Override
    public List<Album> findByTrack(Track t) {
        return SampleData.albums.stream().filter(c -> c.getTracks().contains(t)).collect(Collectors.toList());
    }

    @Override
    public Album save(Album album) {
        int maxId = SampleData.albums.stream()
                .sorted((c1,c2)->c2.getId()-c1.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        album.setId(maxId + 1);
        SampleData.albums.add(album);
        return album;
    }
}
