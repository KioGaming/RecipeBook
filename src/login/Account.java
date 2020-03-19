package login;

import saveload.SaveData;

public class Account{

    private static String username;
    private static String mail;
    private static String password;
    private static String location;
    private static SaveData saveData;
    private static int idUser;

    public Account(int iduser, String username, String mail, String password, String location) {
        idUser = iduser;
        Account.username = username;
        Account.mail = mail;
        Account.password = password;
        Account.location = location;
        saveData = new SaveData();
        saveData.load(idUser, Account.username);
    }

    public Account() {
    }

    public void load() {
        saveData.load(idUser, username);
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
