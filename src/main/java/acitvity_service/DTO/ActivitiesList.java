package acitvity_service.DTO;

import acitvity_service.models.Activity;

import java.util.List;

public record ActivitiesList(Long userId, List<ActivityResponse> activities) {
}
