package adapter.after_v2;

import adapter.after_v2.security.LoginHandler;
import adapter.after_v2.security.UserDetailsService;

public class Client {

    public static void main(String[] args) {
        LoginHandler loginHandler = new LoginHandler(new AccountUserDetailService());

        String login = loginHandler.login("jinia", "jinia");
        System.out.println("login = " + login);
    }

}


