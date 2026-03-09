package music;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import music.model.Album;
import music.service.AlbumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class MusicComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final AlbumService albumService;
    public MusicComponent (AlbumService albumService) { this.albumService = albumService; }

    @PostConstruct
    void init() { log.info("in post construct"); }

    /*@PostConstruct
    void init() {
        List<Album> albums = albumService.getAllAlbums();
        log.info("{} albums found.", albums.size());
        albums.forEach(album -> log.info("{}",album));
    }*/

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments {}", Arrays.asList(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Album> albums = albumService.getAllAlbums();
        log.info("{} albums found.", albums.size());
        albums.forEach(album -> log.info("{}", album));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) { log.info("on context refreshed (from annotated method)"); }
}
