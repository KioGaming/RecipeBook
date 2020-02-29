package settings;

import java.util.HashMap;

final public class Text {

    private static final HashMap<String, String> data = new HashMap<>();

    public static String get(String key){
        return data.get(key);
    }

    public static void init(){
        data.put("SIGN_UP_REPEAT_ERROR", "Введите уникальные ник и почту");
        data.put("SIGN_IN_EMPTY_ERROR", "Заполните поля для входа");
        data.put("SIGN_UP_EMPTY_ERROR", "Заполните поля для регистрации");
        data.put("LOCATION", "Страна, язык");
        data.put("PROGRAM_NAME", "Книга рецептов");
        data.put("MENU_HOME", "Главная");
        data.put("MENU_SHOPPING_LIST","Список покупок");
        data.put("MENU_LIBRARY", "Библиотека");
        data.put("MENU_SEARCH", "Поиск");
        data.put("MENU_THREE_DOTS", "Дополнительно");
        data.put("MENU_ABOUT_US", "Про нас");
        data.put("MENU_TRY_PRO", "Попробуй премиум");
        data.put("MENU_SUPPORT", "Поддержка");
        data.put("MENU_SETTINGS", "Настройки");
        data.put("MENU_SIGN_OUT", "Вийти з аккаунта");
        data.put("PROGRAM_ERROR_TITLE", "Программная ошибка");
        data.put("ADDING_ERROR_TITLE", "Ошибка добавления, выберите записи, которые хотите внести в список покупок");
        data.put("DISHES", "Блюда");
        data.put("DIETS", "Диеты");
    }
}
