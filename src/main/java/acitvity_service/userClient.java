package acitvity_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface userClient {

    @GetMapping("/ping")
    String pingTheUser();
}
