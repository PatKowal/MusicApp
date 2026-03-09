package music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {
    @Bean
    String foo() { return new String("Foo!"); }
}
