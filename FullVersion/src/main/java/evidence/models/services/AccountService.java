package evidence.models.services;

import evidence.models.dtos.AccountDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    void create(AccountDTO accountDTO, boolean isAdmin);
}
