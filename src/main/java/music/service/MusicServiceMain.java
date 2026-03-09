package music.service;

import music.model.Album;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MusicServiceMain {
    public static void main(String[] args) {
        System.out.println("Let's find albums!");

        ApplicationContext context = new AnnotationConfigApplicationContext("music");
        AlbumService service = context.getBean(AlbumService.class);
        AlbumService service2 = context.getBean(AlbumService.class);

        List<Album> albums = service.getAllAlbums();
        System.out.println(albums.size() + " albums found:");
        albums.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo: " + foo);
    }
}
