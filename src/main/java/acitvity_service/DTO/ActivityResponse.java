package acitvity_service.DTO;

import java.time.LocalDateTime;

public record ActivityResponse(Long acitvityId, Long userId, LocalDateTime startTime,LocalDateTime endTime) {
}
