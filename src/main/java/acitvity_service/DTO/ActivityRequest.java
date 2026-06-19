package acitvity_service.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ActivityRequest(LocalDateTime startTime, LocalDateTime endtime) {
}
