package settings;

import java.util.regex.Pattern;

final public class Settings {

    public static int idPlaylistTemp;
    public static boolean verifyNoUsedUsernameOrMailTemp = false;

    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 5000;

    public static final String USERNAME_PATTERN = "^[A-Za-z0-9_]{4,16}$";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{6,20}$";
}