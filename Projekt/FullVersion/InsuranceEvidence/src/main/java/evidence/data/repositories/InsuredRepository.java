package evidence.data.repositories;

import evidence.data.entities.InsuredEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuredRepository extends JpaRepository<InsuredEntity, Long> {
}
