package acitvity_service.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserProfile(String name, UUID userId, String email, LocalDateTime birthDate) {
}
