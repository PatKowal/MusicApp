package music.repository.mem;

import music.model.Album;
import music.model.Author;
import music.model.Track;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    static List<Album> albums = new ArrayList<>();
    static List<Author> authors = new ArrayList<>();
    static List<Track> tracks = new ArrayList<>();

    static {
        Author tolkien = new Author(1, "J.R.R.", "Tolkien");
        Author rowling = new Author(2, "J.K.", "Rowling");
        Author sapkowski = new Author(3, "Andrzej", "Sapkowski");
        Author martin = new Author(4, "George", "Martin");

        Track hobbit = new Track(1, "The Hobbit Theme", tolkien, 320);
        Track lotr = new Track(2, "LOTR Soundtrack", tolkien, 420);
        Track hp1 = new Track(3, "Hedwig's Theme", rowling, 280);
        Track hp2 = new Track(4, "Chamber of Secrets OST", rowling, 300);
        Track witcher = new Track(5, "Witcher Theme", sapkowski, 350);
        Track lastWish = new Track(6, "The Last Wish OST", sapkowski, 330);
        Track got = new Track(7, "Game of Thrones Intro", martin, 410);
        Track dragons = new Track(8, "Dance of Dragons OST", martin, 390);

        bind(hobbit, tolkien);
        bind(lotr, tolkien);
        bind(hp1, rowling);
        bind(hp2, rowling);
        bind(witcher, sapkowski);
        bind(lastWish, sapkowski);
        bind(got, martin);
        bind(dragons, martin);

        Album fantasyCollection = new Album(1, "Fantasy Collection", "fantasy.jpg");
        Album epicThemes = new Album(2, "Epic Themes", "epic.jpg");
        Album magicWorld = new Album(3, "Magic World", "magic.jpg");
        Album darkSaga = new Album(4, "Dark Saga", "dark.jpg");

        bind(fantasyCollection, hobbit);
        bind(fantasyCollection, witcher);
        bind(epicThemes, lotr);
        bind(epicThemes, got);
        bind(magicWorld, hp1);
        bind(magicWorld, hp2);
        bind(darkSaga, dragons);
        bind(darkSaga, lastWish);

        tracks.add(hobbit);
        tracks.add(lotr);
        tracks.add(hp1);
        tracks.add(hp2);
        tracks.add(witcher);
        tracks.add(lastWish);
        tracks.add(got);
        tracks.add(dragons);

        authors.add(tolkien);
        authors.add(rowling);
        authors.add(sapkowski);
        authors.add(martin);

        albums.add(fantasyCollection);
        albums.add(epicThemes);
        albums.add(magicWorld);
        albums.add(darkSaga);
    }

    private static void bind(Album a, Track t) {
        a.addTrack(t);
        t.addAlbum(a);
    }

    private static void bind(Track t, Author a) {
        a.addTrack(t);
        t.setAuthor(a);
    }
}
