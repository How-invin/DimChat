package howin.dimChat.models;

import java.util.regex.Pattern;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNull(){
        return id == null || username == null || password == null;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            '}';
    }

    private final static String emailRegEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private final static String passwordRegEx = "^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,20})$";

    public static boolean isEmail(String email) {
        if (email == null)
            return false;
        return Pattern.compile(emailRegEx).matcher(email).matches();
    }

    public static boolean isPassword(String password) {
        int len = password.length();
        if (password == null)
            return false;
        return Pattern.compile(passwordRegEx).matcher(password).matches();
    }
}
