package music.service.impl;

import music.model.Author;
import music.model.Track;
import org.springframework.stereotype.Component;
import music.repository.AlbumDao;
import music.repository.AuthorDao;
import music.repository.TrackDao;
import music.service.TrackService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class TrackServiceBean implements TrackService {
    private static final Logger log = Logger.getLogger(TrackService.class.getName());

    private AlbumDao albumDao;
    private AuthorDao authorDao;
    private TrackDao trackDao;

    public TrackServiceBean(AlbumDao albumDao, AuthorDao authorDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.authorDao = authorDao;
        this.trackDao = trackDao;
    }

    @Override
    public List<Track> getAllTracks() {
        log.info("searching all tracks...");
        return trackDao.findAll();
    }

    @Override
    public List<Track> getTracksByAuthor(Author a) {
        log.info("searching tracks by author " + a.getId());
        return trackDao.findByAuthor(a);
    }

    @Override
    public Track getTrackById(int id) {
        log.info("searching track by id " + id);
        return trackDao.findById(id);
    }

    @Override
    public Track addTrack(Track t) {
        log.info("about to add track " + t);
        return trackDao.add(t);
    }

    @Override
    public List<Author> getAllAuthors() {
        log.info("searching all authors");
        return authorDao.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        log.info("searching author by id " + id);
        return authorDao.findById(id);
    }

    @Override
    public Author addAuthor(Author a) {
        log.info("about to add author " + a);
        return authorDao.add(a);
    }
}
