package Demo.Service;

import Demo.Model.Account;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService, UserDetailsService {
    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Account getByID(String id) {
        return null;
    }

    @Override
    public List<Account> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public boolean add(Account info) {
        return false;
    }

    @Override
    public boolean update(Account info) {
        return false;
    }

    @Override
    public boolean delete(Account info) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = getSingleByUserName(username);

        if (account == null){
            throw new UsernameNotFoundException(username);
        }

        boolean disabled = !account.getIsEnable();

        UserDetails userDetails = User.withUsername(account.getUserName())
                .password(account.getPassWord())
                .disabled(disabled)
                .authorities(account.getRole())
                .build();

        return userDetails;
    }

    @Override
    public Account getSingleByUserName(String userName) {
        return null;
    }
}
