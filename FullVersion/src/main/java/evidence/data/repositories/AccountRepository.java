package evidence.data.repositories;

import evidence.data.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmail(String email);
}
