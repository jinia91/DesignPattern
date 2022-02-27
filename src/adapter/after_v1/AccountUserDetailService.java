package adapter.after_v1;

import adapter.after_v1.security.UserDetails;
import adapter.after_v1.security.UserDetailsService;

public class AccountUserDetailService implements UserDetailsService {

    private final AccountService accountService;

    public AccountUserDetailService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
