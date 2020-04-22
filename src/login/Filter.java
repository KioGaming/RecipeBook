package login;

import settings.Settings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {

    public static boolean verifyUsername(String username){
        Pattern pattern = Pattern.compile(Settings.USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean verifyMail(String mail){
        Matcher matcher = Settings.VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        return matcher.find();
    }

    public static boolean verifyPassword(String password){
        Pattern pattern = Pattern.compile(Settings.PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean verifyLocation(String location){
        boolean b = false;
        if (location.equals("Україна, ua")) {
            b = true;
        } else if (location.equals("Россия, ru")) {
            b = true;
        } else if (location.equals("England, uk")) {
            b = true;
        }
        return b;
    }
}