package adapter.after_v1.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
