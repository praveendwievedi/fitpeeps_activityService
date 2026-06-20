package acitvity_service.controllers;


import acitvity_service.DTO.ActivitiesList;
import acitvity_service.DTO.ActivityResponse;
import acitvity_service.models.Activity;
import acitvity_service.services.ActivityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activites")
@RequiredArgsConstructor
public class ActivityResponseController {
    private final ActivityServices activityServices;
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllActivitiesForUser(@PathVariable Long userId){
        List<ActivityResponse> acitvities=activityServices.getAllActivityForUsers(userId);
        ActivitiesList userActivities=new ActivitiesList(userId,acitvities);
        return new ResponseEntity<>(userActivities, HttpStatus.OK);
    }
}
