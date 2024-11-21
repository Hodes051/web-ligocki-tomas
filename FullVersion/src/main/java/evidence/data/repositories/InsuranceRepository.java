package evidence.data.repositories;

import evidence.data.entities.InsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
   Page<InsuranceEntity> findByInsuredId(long insuredId, Pageable pageable);
}
