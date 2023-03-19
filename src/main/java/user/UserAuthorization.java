package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserAuthorization {

    private String email;
    private String password;

    public UserAuthorization() {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static final String RANDOM_PASSWORD = RandomStringUtils.randomAlphanumeric(6);

    public static UserAuthorization getCorrectUserLoginAndPassword(CreateUser createUser) {
        UserAuthorization userAuthorization = new UserAuthorization();
        userAuthorization.setEmail(createUser.getEmail());
        userAuthorization.setPassword(createUser.getPassword());
        return userAuthorization;
    }
}