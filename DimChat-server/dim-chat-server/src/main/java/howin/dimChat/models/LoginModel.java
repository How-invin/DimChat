package howin.dimChat.models;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

public class LoginModel {
    private String email;
    private String password;

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
