package saveload;

import exception.ModelException;
import login.DatabaseHandler;
import model.Dish;
import model.ShoppingList;
import settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class SaveLoad
{
    private static JAXBContext context;
    private static Unmarshaller um;
    private static Marshaller m;
    private static Wrapper wrapper;


    public static void load(SaveData sd, String username)
    {
        try
        {
            context = JAXBContext.newInstance(Wrapper.class);
            um = context.createUnmarshaller();
            wrapper = (Wrapper) um.unmarshal(Settings.getFileSave(username));

            sd.setLikedDishes(new ArrayList<>());
            sd.setLikedDishes(wrapper.getLikedDishes());
        } catch (JAXBException e) {
            System.out.println("Даних нету!");
            e.printStackTrace();
        }
        try
        {
            context = JAXBContext.newInstance(Wrapper.class);
            um = context.createUnmarshaller();
            wrapper = (Wrapper) um.unmarshal(Settings.getFileSave(username));

            sd.setShoppingList(new ShoppingList());
            sd.setShoppingList(wrapper.getShoppingList());
        } catch (JAXBException e) {
            System.out.println("Даних нету!");
            e.printStackTrace();
        }
        ArrayList<Dish> dishes = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet =  databaseHandler.getRecipe();
        try
        {
            while (resultSet.next())
            {
                String title = resultSet.getString("title");

                String photo = resultSet.getString("photo");

                String description = resultSet.getString("description");

                ArrayList<String> recipe = new ArrayList<>();
                Collections.addAll(recipe, resultSet.getString("recipe").split("/"));

                ArrayList<String> groceryList = new ArrayList<>();
                Collections.addAll(groceryList, resultSet.getString("groceryList").split("/"));

                ArrayList<Double> countList = strListToDoubleList(resultSet.getString("countList").split("/"));

                ArrayList<String> unitsOfMeasurementList = new ArrayList<>();
                Collections.addAll(unitsOfMeasurementList, resultSet.getString("unitsOfMeasurementList").split("/"));

                int numberOfLikes = Integer.parseInt(resultSet.getString("numberOfLikes"));

                Dish dish = new Dish(title, photo, description, recipe, groceryList, countList, unitsOfMeasurementList, numberOfLikes);
                dishes.add(dish);
            }
            sd.setDishes(dishes);
        } catch (SQLException e) { e.printStackTrace(); }
          catch (ModelException e) { e.printStackTrace(); }
    }

    public static void save(SaveData sd, String username){
        try
        {
            context = JAXBContext.newInstance(Wrapper.class);
            m = context.createMarshaller();
            m.setProperty("jaxb.formatted.output", true);
            wrapper = new Wrapper();

            wrapper.setLikedDishes(sd.getLikedDishes());
            wrapper.setShoppingList(sd.getShoppingList());

            m.marshal(wrapper, Settings.getFileSave(username));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static boolean saveRecipe(Dish recipe){
        boolean b = true;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.setRecipe(recipe.getTitle(), recipe.getPhoto(), recipe.getDescription(), recipe.getRecipe(), recipe.getGroceryList(),
                                  recipe.getCountList(), recipe.getUnitsOfMeasurementList(), recipe.getNumberOfLikes());
        return b;
    }

    public  static ArrayList<Double> strListToDoubleList(String[] stringArrayList){
        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for (int i = 0; i < stringArrayList.length; i++) {
            doubleArrayList.add(Double.parseDouble(stringArrayList[i]));
        }
        return doubleArrayList;
    }
}
