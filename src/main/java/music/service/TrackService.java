package music.service;

import music.model.Artist;
import music.model.Track;

import java.util.List;

public interface TrackService {
    List<Track> getAllTracks();
    List<Track> getTracksByArtist(Artist a);
    Track getTrackById(int id);
    Track addTrack(Track t);
    List<Artist> getAllArtists();
    Artist getArtistById(int id);
    Artist addArtist(Artist a);
}
