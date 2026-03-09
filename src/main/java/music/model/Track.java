package music.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private int id;
    private String title;
    private Author author;
    private int duration;

    private List<Album> albums = new ArrayList<>();

    public Track(int id, String title, Author author, int duration) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", duration=" + duration +
                '}';
    }
}
