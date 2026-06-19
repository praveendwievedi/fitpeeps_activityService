package acitvity_service.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-servie")
public interface UserDetails {
    @GetMapping("/check/{id}")
    public boolean findUser();
}
