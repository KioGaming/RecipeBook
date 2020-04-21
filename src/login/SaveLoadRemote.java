package login;

import model.Account;
import model.SaveData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class SaveLoadRemote {
    public static void addDishInPlaylist(int id, int id1) {

    }

    public static void removeDishInPlaylist(int id, int id1) {
    }

    public static void removeLikedDishes(int idUser, int id) {
    }

    public static int addPlaylist(int idUser, String name) {
        return 0;
    }

    public static void removePlaylist(int id) {

    }

    public static void saveLikedDishes(int iduser, int iddish) {
    }

    public static void removeOneLike(int id) {
    }

    public static void changePassword(String mail, String text) {
    }

    public static void changeUsername(String mail, String text) {
    }

    public static void changeLocation(String mail, String value) {
    }

    public static void addOneLike(int id) {
    }

    public static Account loadInXML(int id) {
        Account account = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) um.unmarshal(new File("D:/account.rb"));
            account = new Account(wrapper.getId(), wrapper.getUsername(), wrapper.getMail(), wrapper.getPassword(), wrapper.getLocation(), wrapper.getRole());
            SaveData saveData = new SaveData();
            saveData.setDishes(new ArrayList<>());
            saveData.setDishes(wrapper.getDishes());
            saveData.setLike(new ArrayList<>());
            saveData.setLike(wrapper.getLike());
            saveData.setPlaylists(new ArrayList<>());
            saveData.setPlaylists(wrapper.getPlaylists());
            saveData.reloadAllLists();
            account.setSaveData(saveData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return account;
    }
}
