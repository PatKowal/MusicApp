package music.service;

import music.model.Album;
import music.model.Track;

import java.util.List;

public interface AlbumService {
    Album getAlbumById(int id);
    List<Album> getAllAlbums();
    List<Album> getAlbumsByTrack(Track t);
    List<Track> getTracksInAlbum(Album a);
    Album addAlbum(Album a);
}
