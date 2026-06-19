package acitvity_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class CheckConnection {
    @GetMapping("/ping")
    public ResponseEntity<?> greeting(){
        return new ResponseEntity<>("Hello from the Acitivity Service", HttpStatus.OK);
    }
}
