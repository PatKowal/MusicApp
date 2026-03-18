package music.repository.mem;

import music.model.Album;
import music.model.Artist;
import music.model.Track;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    static List<Album> albums = new ArrayList<>();
    static List<Artist> artists = new ArrayList<>();
    static List<Track> tracks = new ArrayList<>();

    static {
            Artist queen = new Artist(1, "Freddie", "Mercury");
            Artist duaLipa = new Artist(2, "Dua", "Lipa");
            Artist hansZimmer = new Artist(3, "Hans", "Zimmer");
            Artist milesDavis = new Artist(4, "Miles", "Davis");
            Artist ladyGaga = new Artist(5, "Lady", "Gaga");
            Artist michelApril = new Artist(6, "Michel", "F. April");

            Track t1 = new Track(1, "Bohemian Rhapsody", queen, 354,"bohemianrapsody.mp3");
            Track t2 = new Track(2, "Levitating", duaLipa, 203,"levitating.mp3");
            Track t3 = new Track(3, "Time", hansZimmer, 275,"time.mp3");
            Track t4 = new Track(4, "So What", milesDavis, 562,"sowhat.mp3");
            Track t5 = new Track(5, "Stupid Love", ladyGaga, 193,"stupidlove.mp3");
            Track t6 = new Track(6, "MiNA", michelApril, 544,"D:/music/MiNA.mp3");

            bind(t1, queen);
            bind(t2, duaLipa);
            bind(t3, hansZimmer);
            bind(t4, milesDavis);
            bind(t5, ladyGaga);
            bind(t6, michelApril);

            Album a1 = new Album(1, "A Night at the Opera", "https://upload.wikimedia.org/wikipedia/en/4/42/Queen_A_Night_At_The_Opera.png");
            Album a2 = new Album(2, "Future Nostalgia", "https://upload.wikimedia.org/wikipedia/en/f/f5/Dua_Lipa_-_Future_Nostalgia.png");
            Album a3 = new Album(3, "Inception OST", "https://upload.wikimedia.org/wikipedia/en/0/03/Hans_Zimmer_Inception_OST.jpg");
            Album a4 = new Album(4, "Kind of Blue", "https://upload.wikimedia.org/wikipedia/en/9/9c/MilesDavisKindofBlue.jpg");
            Album a5 = new Album(5, "Chromatica", "https://upload.wikimedia.org/wikipedia/en/a/a0/Lady_Gaga_-_Chromatica.png");
            Album a6 = new Album(6, "All-Kill", "AllKill.png");

            bind(a1, t1);
            bind(a2, t2);
            bind(a3, t3);
            bind(a4, t4);
            bind(a5, t5);
            bind(a6, t6);

            tracks.add(t1);
            tracks.add(t2);
            tracks.add(t3);
            tracks.add(t4);
            tracks.add(t5);
            tracks.add(t6);

            artists.add(queen);
            artists.add(duaLipa);
            artists.add(hansZimmer);
            artists.add(milesDavis);
            artists.add(ladyGaga);
            artists.add(michelApril);

            albums.add(a1);
            albums.add(a2);
            albums.add(a3);
            albums.add(a4);
            albums.add(a5);
            albums.add(a6);
        }

    private static void bind(Album a, Track t) {
        a.addTrack(t);
        t.addAlbum(a);
    }

    private static void bind(Track t, Artist a) {
        a.addTrack(t);
        t.setArtist(a);
    }
}
