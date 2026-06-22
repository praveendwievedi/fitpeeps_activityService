package acitvity_service.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ActivityResponse(Long acitvityId,
                               Long userId,
                               String activityType,
                               LocalDate activityDate,
                               LocalDateTime startTime,
                               LocalDateTime endTime) {
}
