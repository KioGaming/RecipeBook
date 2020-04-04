package login;

import saveload.SaveData;

public class Account{

    private static String username;
    private static String mail;
    private static String password;
    private static String location;
    private static SaveData saveData;
    private static int idUser;
    private static String role;

    public Account(int iduser, String username, String mail, String password, String location, String role) {
        idUser = iduser;
        Account.username = username;
        Account.mail = mail;
        Account.password = password;
        Account.location = location;
        Account.role = role;
        saveData = new SaveData();
        saveData.load(idUser);
    }

    public Account() {
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        Account.role = role;
    }

    public void load() {
        saveData.load(idUser);
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        username = userName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        Account.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        Account.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Account.password = password;
    }

    public SaveData getSaveData(){
        return saveData;
    }

    public void setSaveData(SaveData saveData) {
        Account.saveData = saveData;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        Account.location = location;
    }

    @Override
    public String toString() {
        return username + " " + mail + " " + password + " " + location;//+ " " + saveData.toString();
    }
}
