package music.service.impl;

import music.model.Album;
import music.model.Track;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import music.repository.AlbumDao;
import music.repository.TrackDao;
import music.service.AlbumService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class AlbumServiceBean implements AlbumService {
    private static final Logger log = Logger.getLogger(AlbumService.class.getName());

    private AlbumDao albumDao;
    private TrackDao trackDao;

    //@Autowired
    public AlbumServiceBean(AlbumDao albumDao, TrackDao trackDao) {
        log.info("creating album service bean");
        this.albumDao = albumDao;
        this.trackDao = trackDao;
    }

    @Override
    public Album getAlbumById(int id) {
        log.info("searching album by id " + id);
        return albumDao.findById(id);
    }

    @Override
    public List<Track> getTracksInAlbum(Album a) {
        log.info("searching tracks in album " + a.getId());
        return trackDao.findByAlbum(a);
    }

    @Override
    public List<Album> getAllAlbums() {
        log.info("searching all albums");
        return albumDao.findAll();
    }

    @Override
    public List<Album> getAlbumsByTrack(Track t) {
        log.info("searching albums by track " + t.getId());
        return albumDao.findByTrack(t);
    }
}
