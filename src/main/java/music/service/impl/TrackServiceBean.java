package music.service.impl;

import music.model.Artist;
import music.model.Track;
import music.repository.AlbumDao;
import music.repository.ArtistDao;
import music.repository.TrackDao;
import music.service.TrackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TrackServiceBean implements TrackService {
    private static final Logger log = Logger.getLogger(TrackService.class.getName());

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private TrackDao trackDao;

    public TrackServiceBean(AlbumDao albumDao, ArtistDao artistDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.trackDao = trackDao;
    }

    @Override
    public List<Track> getAllTracks() {
        log.info("searching all tracks...");
        return trackDao.findAll();
    }

    @Override
    public List<Track> getTracksByArtist(Artist a) {
        log.info("searching tracks by artist " + a.getId());
        return trackDao.findByArtist(a);
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
    public List<Artist> getAllArtists() {
        log.info("searching all authors");
        return artistDao.findAll();
    }

    @Override
    public Artist getArtistById(int id) {
        log.info("searching author by id " + id);
        return artistDao.findById(id);
    }

    @Override
    public Artist addArtist(Artist a) {
        log.info("about to add author " + a);
        return artistDao.add(a);
    }
}
