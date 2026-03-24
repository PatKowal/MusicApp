package music.config;

import lombok.RequiredArgsConstructor;
import music.service.TrackService;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MusicInfoController implements InfoContributor {
    private final TrackService trackService;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("tracks", trackService.getAllTracks().size());
    }
}
