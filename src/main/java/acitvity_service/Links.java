package acitvity_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Links {
    private final userClient userClient;
    @GetMapping("/test-users")
    public String linkToUserService(){
        String userResponse=userClient.pingTheUser();
        return userResponse;
    }

}
