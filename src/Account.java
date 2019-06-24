package wmadp201_assginment4_group.src;

public class Account {
    private String userName;
    private String password;
    private User user;

    public Account(String userName, String password, User user) {
        this.userName = userName;
        this.password = password;
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
