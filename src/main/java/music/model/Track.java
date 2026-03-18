package music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    private int duration;
    @Column(name = "file_uri")
    private String fileUri;
    @ManyToMany
    @JoinTable(
            name = "track_album",
            joinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Album> albums = new ArrayList<>();

public Track(Integer id, String title, Artist artist, int duration, String fileUri) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.fileUri = fileUri;
    }

    public Track() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getFileUri() { return fileUri; }

    public void setFileUri(String fileUri) { this.fileUri = fileUri; }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", duration=" + duration +
                '}';
    }
}
