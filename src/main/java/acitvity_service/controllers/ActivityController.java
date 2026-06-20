package acitvity_service.controllers;

import acitvity_service.DTO.ActivityRequest;
import acitvity_service.DTO.ActivityResponse;
import acitvity_service.models.Activity;
import acitvity_service.services.ActivityServices;
import acitvity_service.utils.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityServices activityServices;
    private final UserDetails userDetails;

    @PostMapping("/user/{userId}/register")
    public ResponseEntity<?> createActivity(@PathVariable Long userId, @RequestBody ActivityRequest request){
//        if(!userDetails.findUser())return new ResponseEntity<>("No users Found",HttpStatus.OK);
        ActivityResponse activity=activityServices.createAcitvity(request,userId);

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<?> findActivity(@PathVariable Long userId,@PathVariable Long activityId){
        Optional<ActivityResponse> foundActivity=activityServices.findActivity(userId,activityId);

        if(foundActivity.isEmpty())return new ResponseEntity<>("No such acitvity Found",HttpStatus.OK);
        return new ResponseEntity<>(foundActivity,HttpStatus.OK);
    }
}
