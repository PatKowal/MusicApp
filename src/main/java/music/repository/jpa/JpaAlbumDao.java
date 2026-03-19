package music.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import music.model.Album;
import music.model.Track;
import music.repository.AlbumDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Primary
public class JpaAlbumDao implements AlbumDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Album> findAll() {
        return entityManager
                .createQuery("select a from Album a")
                .getResultList();
    }

    @Override
    public Album findById(int id) {
        return entityManager.find(Album.class, id);
    }

    @Override
    public List<Album> findByTrack(Track t) {
        return entityManager
                .createQuery("select a from Album a inner join a.tracks track where track =: track")
                .setParameter("track", t)
                .getResultList();
    }

    @Override
    public Album save(Album album) {
        entityManager.persist(album);
        return album;
    }
}
