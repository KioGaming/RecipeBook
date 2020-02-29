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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SaveLoad
{
    private static JAXBContext context;
    private static Unmarshaller um;
    private static Marshaller m;
    private static Wrapper wrapper;


    public static void load(SaveData sd, String username)
    {
        /*ArrayList<String> recipeList = new ArrayList<>();
        ArrayList<Dish> dishes = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(Settings.FILE_LIST_RECIPE);
            while (scanner.hasNext())
                recipeList.add(scanner.nextLine().trim());
            context = JAXBContext.newInstance(Wrapper.class);
            um = context.createUnmarshaller();
            for (int i = 0; i < recipeList.size(); i++)
            {
                wrapper = (Wrapper) um.unmarshal(new File(recipeList.get(i)));
                dishes.add(wrapper.getDish());
            }
            sd.setDishes(new ArrayList<>());
            sd.setDishes(dishes);
        } catch (JAXBException | FileNotFoundException e) {
            System.out.println("Даних нету!");
            e.printStackTrace();
        }*/
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
                System.out.println(dish.toString());
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
        /*try
        {
            File file = new File("saves/" + recipe.getTitle() + ".rb");
            if(!file.exists())
            {
                file.createNewFile();
                context = JAXBContext.newInstance(Wrapper.class);
                m = context.createMarshaller();
                m.setProperty("jaxb.formatted.output", true);
                wrapper = new Wrapper();

                wrapper.setDishes(recipe);
                m.marshal(wrapper, file);

                FileWriter fileWriter = new FileWriter( Settings.FILE_LIST_RECIPE,true);
                fileWriter.write(recipe.getTitle() + "\n");
                fileWriter.close();
            } else {
                b = false;
            }
        } catch (JAXBException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/
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
