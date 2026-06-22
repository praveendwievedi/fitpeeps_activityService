package acitvity_service.controllers;


import acitvity_service.DTO.ActivitiesList;
import acitvity_service.DTO.ActivityResponse;
import acitvity_service.services.ActivityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityResponseController {
    private final ActivityServices activityServices;
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllActivitiesForUser(@PathVariable Long userId){
        List<ActivityResponse> activities =activityServices.getAllActivityForUsers(userId);
        ActivitiesList userActivities=new ActivitiesList(userId, activities);
        return new ResponseEntity<>(userActivities, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/{Date}")
    public ResponseEntity<?> getAllActivitiesForTheDate(@PathVariable Long userId, @PathVariable LocalDate Date){
        List<ActivityResponse> usersActivities=activityServices.getAllActivityForDate(userId,Date);
        ActivitiesList activities=new ActivitiesList(userId,usersActivities);
        return new ResponseEntity<>(activities,HttpStatus.OK);
    }
    @GetMapping("/user/{userId}/month")
    public ResponseEntity<?> getAllActivitiesForTheMonth(@PathVariable Long userId, @PathVariable Integer month){
        List<ActivityResponse> usersActivities=activityServices.getAllActivityForMonth(userId,month);
        ActivitiesList activities=new ActivitiesList(userId,usersActivities);
        return new ResponseEntity<>(activities,HttpStatus.OK);
    }
}
