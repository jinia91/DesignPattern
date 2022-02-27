package adapter.after_v2;

import adapter.after_v2.security.UserDetails;

public class AccountUserDetails extends Account implements UserDetails {
    public AccountUserDetails(Account account) {
        this.setEmail(account.getEmail());
        this.setName(account.getName());
        this.setPassword(account.getPassword());
    }

    @Override
    public String getUsername() {
        return super.getName();
    }
}
