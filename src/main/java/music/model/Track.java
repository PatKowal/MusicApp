package music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private int id;
    private String title;
    private Artist artist;
    private int duration;
    @JsonIgnore
    private List<Album> albums = new ArrayList<>();

    public Track(int id, String title, Artist artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public Track() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
    public void addAlbum(Album a) { this.albums.add(a); }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", duration=" + duration +
                '}';
    }
}
