package music.service;

import music.model.Author;
import music.model.Track;

import java.util.List;

public interface TrackService {
    List<Track> getAllTracks();
    List<Track> getTracksByAuthor(Author a);
    Track getTrackById(int id);
    Track addTrack(Track t);
    List<Author> getAllAuthors();
    Author getAuthorById(int id);
    Author addAuthor(Author a);
}
