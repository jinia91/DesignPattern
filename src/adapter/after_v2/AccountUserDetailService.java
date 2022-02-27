package adapter.after_v2;

import adapter.after_v2.security.UserDetails;
import adapter.after_v2.security.UserDetailsService;

public class AccountUserDetailService extends AccountService implements  UserDetailsService{
    @Override
    public UserDetails loadUser(String username) {
        Account account = findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
