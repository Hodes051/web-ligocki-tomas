package evidence.models.services;

import evidence.data.entities.AccountEntity;
import evidence.data.repositories.AccountRepository;
import evidence.models.dtos.AccountDTO;
import evidence.models.exceptions.DuplicateEmailException;
import evidence.models.exceptions.PasswordsDoNotEqualException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(AccountDTO accountDTO, boolean isAdmin) {
        if (!accountDTO.getPassword().equals(accountDTO.getConfirmPassword()))
            throw new PasswordsDoNotEqualException();

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setEmail(accountDTO.getEmail());
        accountEntity.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        accountEntity.setAdmin(isAdmin);

        try {
            accountRepository.save(accountEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}
