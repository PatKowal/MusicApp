package music.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRest {
    @GetMapping("/")
    String hello() { return "Hello World!"; }
}
