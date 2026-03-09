package music.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class HelloRest {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
//    @ResponseBody
    String hello() { return "Hello World!"; }
}
