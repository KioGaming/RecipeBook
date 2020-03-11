package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {

    private static final String USERNAME_PATTERN = "^[A-Za-z0-9_]{4,16}$";

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                                                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{6,20}$";

    //private static final String LOCATION_PATTERN = "^[A-Z]{2}$";

    public static boolean verifyUsername(String username){
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean verifyMail(String mail){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public static boolean verifyPassword(String password){
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean verifyLocation(String location){
        boolean b = false;
        if (location == "Україна, ua") {
            b = true;
        } else if (location == "Россия, ru") {
            b = true;
        } else if (location == "England, uk") {
            b = true;
        }
        return b;
    }
}