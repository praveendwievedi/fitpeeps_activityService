package acitvity_service.services;

import acitvity_service.DTO.ActivityRequest;
import acitvity_service.DTO.ActivityResponse;
import acitvity_service.models.Activity;
import acitvity_service.repos.ActivityRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityServices {
    private final ActivityRepo activityRepo;

    public ActivityResponse createAcitvity(ActivityRequest request, Long userId){
        Activity newActivity=new Activity();
        newActivity.setEndTime(request.endtime());
        newActivity.setStartTime(request.startTime());
        newActivity.setUserId(userId);

        Optional<Activity> activity= Optional.of(activityRepo.save(newActivity));
        Activity savedActivity=activity.get();
        return new ActivityResponse(savedActivity.getId(), savedActivity.getUserId(),savedActivity.getStartTime(),savedActivity.getEndTime());
    }

    public Optional<ActivityResponse> findActivity(Long userId,Long activityId){
        Optional<Activity> existingAcitvity=checkActivity(activityId);
        if(existingAcitvity.isEmpty()) return Optional.empty();

        return Optional.of(new ActivityResponse(existingAcitvity.get().getId(),existingAcitvity.get().getUserId(),existingAcitvity.get().getStartTime(), existingAcitvity.get().getEndTime()));
    }

    public Optional<Activity> checkActivity(Long activityId){
        return activityRepo.findById(activityId);
    }

    public List<ActivityResponse> getAllActivityForUsers(Long userId){
        return activityRepo.findAllActivitiesByUserId(userId).stream()
                .map(
                        activity -> new ActivityResponse(activity.getId(), activity.getUserId(), activity.getStartTime(),activity.getEndTime())
                ).toList();
    }
}
