package acitvity_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class connection {
    @GetMapping("/ping")
    public String pong(){
        return "Hello from the backend";
    }
}
