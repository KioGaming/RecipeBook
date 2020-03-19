package settings;

import java.io.File;

final public class Settings {

    public static final String FONT_LOBSTER = "fonts/lobster.ttf";

    public static File FILE_LIST_RECIPE = new File("saves/default.rb");
    private static final File SAVE_DIR = new File("saves/");
    private static final String SAVE_FILE_EXT = "rb";
    private static final String IMAGE_DIR = "images/";

    public static final String USER_TABLE = "users";
    public static final String USER_ID = "idusers";
    public static final String USER_USERNAME = "username";
    public static final String USER_MAIL = "mail";
    public static final String USER_PASSWORD = "password";
    public static final String USER_LOCATION = "location";

    public static final String DISH_TABLE = "dish";
    public static final String DISH_ID = "iddish";
    public static final String DISH_TITLE = "title";
    public static final String DISH_PHOTO = "photo";
    public static final String DISH_DESCRIPTION = "description";
    public static final String DISH_RECIPE = "recipe";
    public static final String DISH_GROCERYLIST = "groceryList";
    public static final String DISH_COUNTLIST = "countList";
    public static final String DISH_UNITSOFMEASUREMENTLIST = "unitsOfMeasurementList";
    public static final String DISH_NUMBER_OF_LIKES = "numberOfLikes";
    public static final String DISH_CATEGORY = "category";

    public static final String LIKED_DISHES_TABLE = "liked_dishes";
    public static final String LIKED_DISHES_DISHTITLE = "dishtitle";

    public static File getFileSave(String username){
        return new File( SAVE_DIR + "/" + username + "." + SAVE_FILE_EXT);
    }

    public static String getImageDir() {
        return IMAGE_DIR;
    }
}
