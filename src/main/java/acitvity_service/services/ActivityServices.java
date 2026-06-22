package acitvity_service.services;

import acitvity_service.DTO.ActivityRequest;
import acitvity_service.DTO.ActivityResponse;
import acitvity_service.models.Activity;
import acitvity_service.repos.ActivityRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityServices {
    private final ActivityRepo activityRepo;

    public ActivityResponse convertToActivityResponse(Activity savedActivity){
        return new ActivityResponse(savedActivity.getId(),
                savedActivity.getUserId(),
                savedActivity.getActivityType(),
                savedActivity.getActivityDate(),
                savedActivity.getStartTime(),
                savedActivity.getEndTime());
    }

    public ActivityResponse createAcitvity(ActivityRequest request, Long userId){
        Activity newActivity=new Activity();
        newActivity.setEndTime(request.endtime());
        newActivity.setStartTime(request.startTime());
        newActivity.setUserId(userId);
        newActivity.setActivityType(request.activityType().toUpperCase());

        Optional<Activity> activity= Optional.of(activityRepo.save(newActivity));
        Activity savedActivity=activity.get();
        return convertToActivityResponse(savedActivity);
    }

    public Optional<ActivityResponse> findActivity(Long userId,Long activityId){
        Optional<Activity> existingAcitvity=checkActivity(activityId);
        return (existingAcitvity.isEmpty() ? Optional.empty():Optional.of(convertToActivityResponse(existingAcitvity.get())));
    }

    public Optional<Activity> checkActivity(Long activityId){
        return activityRepo.findById(activityId);
    }

    public List<ActivityResponse> getAllActivityForUsers(Long userId){
        return activityRepo.findAllActivitiesByUserId(userId).stream()
                .map(
                        this::convertToActivityResponse
                ).toList();
    }

    public List<ActivityResponse> getAllActivityForDate(Long userId, LocalDate date){
        List<ActivityResponse> userActivities=getAllActivityForUsers(userId);
        return userActivities.stream().filter(
           activityResponse -> activityResponse.activityDate()==date
        ).toList();
    }

    public List<ActivityResponse> getAllActivityForMonth(Long userId,Integer month){
        List<ActivityResponse> userActivities=getAllActivityForUsers(userId);
        return userActivities.stream().filter(
                activityResponse -> activityResponse.activityDate().getMonthValue()==month
        ).toList();
    }
}
