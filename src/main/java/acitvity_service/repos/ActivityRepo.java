package acitvity_service.repos;

import acitvity_service.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepo extends JpaRepository<Activity,Long> {
    List<Activity> findAllActivitiesByUserId(Long userId);

}
