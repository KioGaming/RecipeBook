package login;

import model.Account;
import model.SaveData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class SaveLoadRemote {

    public static Account loadInXML() {
        Account account = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            File file = new File(System.getenv("APPDATA") + "/recipebook/account.rb");
            Wrapper wrapper = (Wrapper) um.unmarshal(file);
            account = new Account(wrapper.getId(), wrapper.getUsername(), wrapper.getMail(), wrapper.getPassword(), wrapper.getLocation(), wrapper.getRole());
            SaveData saveData = new SaveData();
            saveData.setDishes(wrapper.getDishes());
            if (saveData.getDishes() == null) {
                saveData.setDishes(new ArrayList<>());
            }
            saveData.setLike(wrapper.getLike());
            if (saveData.getLike() == null) {
                saveData.setLike(new ArrayList<>());
            }
            saveData.setPlaylists(wrapper.getPlaylists());
            if (saveData.getPlaylists() == null) {
                saveData.setPlaylists(new ArrayList<>());
            }
            saveData.reloadAllLists();
            account.setSaveData(saveData);
            file.delete();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static void addDishInPlaylist(int idPlaylist, int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("addDishInPlaylist", mail, password, idPlaylist, idDish), "Thread");
        thread.start();
    }

    public static void removeDishInPlaylist(int idPlaylist, int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("removeDishInPlaylist", mail, password, idPlaylist, idDish), "Thread");
        thread.start();
    }

    public static void removeLikedDishes(int idUser, int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("removeLikedDishes", mail, password, idUser, idDish), "Thread");
        thread.start();
    }

    public static void saveLikedDishes(int idUser, int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("saveLikedDishes", mail, password, idUser, idDish), "Thread");
        thread.start();
    }

    public static void addPlaylist(int idUser, String playlistTitle, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("addPlaylist", mail, password, idUser, playlistTitle), "Thread");
        thread.start();
    }

    public static void removePlaylist(int idPlaylist, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("removePlaylist", mail, password, idPlaylist), "Thread");
        thread.start();
    }

    public static void removeOneLike(int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("removeOneLike", mail, password, idDish), "Thread");
        thread.start();
    }

    public static void changePassword(String newPassword, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("changePassword", mail, password, newPassword), "Thread");
        thread.start();
    }

    public static void changeUsername(String newUsername, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("changeUsername", mail, password, newUsername), "Thread");
        thread.start();
    }

    public static void changeLocation(String newLocation, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("changeLocation", mail, password, newLocation), "Thread");
        thread.start();
    }

    public static void addOneLike(int idDish, String mail, String password) {
        Thread thread = new Thread(new ThreadForDB("addOneLike", mail, password, idDish), "Thread");
        thread.start();
    }

    public static void verifyNoUsedUsernameOrMail(String username, String mail) {
        Thread thread = new Thread(new ThreadForDB("verifyNoUsedUsernameOrMail", username, mail, true), "Thread");
        thread.start();
    }
}
