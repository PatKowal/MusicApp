package music.service.impl;

import lombok.RequiredArgsConstructor;
import music.model.Artist;
import music.model.Track;
import music.repository.AlbumDao;
import music.repository.ArtistDao;
import music.repository.TrackDao;
import music.service.TrackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TrackServiceBean implements TrackService {
    private static final Logger log = Logger.getLogger(TrackService.class.getName());

    private final AlbumDao albumDao;
    private final ArtistDao artistDao;
    private final TrackDao trackDao;
    private final PlatformTransactionManager transactionManager;

//    public TrackServiceBean(AlbumDao albumDao, ArtistDao artistDao, TrackDao trackDao, PlatformTransactionManager transactionManager) {
//        this.albumDao = albumDao;
//        this.artistDao = artistDao;
//        this.trackDao = trackDao;
//        this.transactionManager = transactionManager;
//    }

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Track addTrack(Track t) {
        log.info("about to add track " + t);
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            t = trackDao.add(t);
            if(t.getTitle().equals("Apocalypse Now")){
                throw new RuntimeException("NO! not yet...");
            }
            transactionManager.commit(transactionStatus);
        } catch (RuntimeException e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
        return t;
//        return trackDao.add(t);
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
