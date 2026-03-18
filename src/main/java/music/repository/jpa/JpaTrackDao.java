package music.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import music.model.Album;
import music.model.Artist;
import music.model.Track;
import music.repository.TrackDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaTrackDao implements TrackDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Track> findAll() {
        return entityManager
                .createQuery("select t from Track t")
                .getResultList();
    }

    @Override
    public Track findById(int id) { return entityManager.find(Track.class, id); }

    @Override
    public List<Track> findByArtist(Artist a) {
        return entityManager
                .createQuery("select t from Track t where t.artist =: artist")
                .setParameter("artist", a)
                .getResultList();
    }

    @Override
    public List<Track> findByAlbum(Album a) {
        return entityManager
                .createQuery("select t from Track t inner join t.albums album where album =: album")
                .setParameter("album", a)
                .getResultList();
    }

    @Override
    public Track add(Track t) {
        return null;
    }
}
