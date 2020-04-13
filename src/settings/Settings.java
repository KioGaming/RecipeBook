package settings;

import java.util.regex.Pattern;

final public class Settings {

    public static final String MAIL_ADDRESS = "olexienko.alex@gmail.com";
    public static final String MAIL_PASSWORD = "Vova_2003";

    public static final String USERNAME_PATTERN = "^[A-Za-z0-9_]{4,16}$";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{6,20}$";


    public static final String FONT_LOBSTER = "fonts/lobster.ttf";
    private static final String IMAGE_DIR = "resources/images/";

    public static final String USER_TABLE = "users";
    public static final String USER_ID = "idusers";
    public static final String USER_USERNAME = "username";
    public static final String USER_MAIL = "mail";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PASSWORD_SALT = "salt";
    public static final String USER_LOCATION = "location";
    public static final String USER_ROLE = "rolename";

    public static final String DISH_TABLE = "dish";
    public static final String DISH_ID = "iddishes";
    public static final String DISH_TITLE = "title";
    public static final String DISH_PHOTO = "photo";
    public static final String DISH_DESCRIPTION = "description";
    public static final String DISH_RECIPE = "recipe";
    public static final String DISH_GROCERYLIST = "groceryList";
    public static final String DISH_WEIGTHLIST = "weightList";
    public static final String DISH_NUMBER_OF_LIKES = "numberOfLikes";
    public static final String DISH_CATEGORY = "category";

    public static final String LIKED_DISHES_TABLE = "liked_dishes";
    public static final String LIKED_DISHES_ID = "liked_dishes_key";
    public static final String LIKED_DISHES_USER_ID = "idusers";
    public static final String LIKED_DISHES_DISH_ID = "iddishes";

    public static final String PLAYLISTS_TABLE = "playlists";
    public static final String PLAYLISTS_ID = "idplaylists";
    public static final String PLAYLISTS_NAME = "name";

    public static final String USER_PLAYLISTS_TABLE = "user_playlist";
    public static final String USER_PLAYLISTS_IDPLAYLIST = "idplaylist";
    public static final String USER_PLAYLISTS_IDUSER = "iduser";
    public static final String USER_PLAYLISTS_ID = "iduser_playlists";

    public static final String PLAYLISTS_DISH_TABLE = "playlist_dish";
    public static final String PLAYLISTS_DISH_ID = "idplaylist_dish";
    public static final String PLAYLISTS_DISH_PLAYLISTID = "playlistid";
    public static final String PLAYLISTS_DISH_DISHID = "dishid";

    public static String getImageDir() {
        return IMAGE_DIR;
    }
}