package acitvity_service.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "user-servie")
public interface UserDetails {
    @GetMapping("/user/{id}")
    public boolean findUser();


    // we want to implemet the
//    @GetMapping("/user/{id}")
//    public Optional<User> getUserDetails();
}
