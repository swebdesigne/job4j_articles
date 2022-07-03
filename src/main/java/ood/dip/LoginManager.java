package ood.dip;

public class LoginManager {
    String name;
    int age;
    SimpleLogin simpleLogin = new SimpleLogin();

    public void login(User user) {
        simpleLogin.authenticate(user);
    }
}
