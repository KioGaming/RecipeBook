package model;

import java.util.Objects;

public class Account {

    private static int id;
    private static String username;
    private static String mail;
    private static String password;
    private static String location;
    private static String role;
    private static SaveData saveData;

    public Account(int id, String username, String mail, String password, String location, String role) {
        Account.id = id;
        Account.username = username;
        Account.mail = mail;
        Account.password = password;
        Account.location = location;
        Account.role = role;
        saveData = new SaveData();
    }

    public Account() {
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        Account.role = role;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        username = userName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        Account.location = location;
    }

    public int getIdUser() {
        return id;
    }

    public void setIdUser(int idUser) {
        Account.id = idUser;
    }

    public SaveData getSaveData() {
        return saveData;
    }

    public void setSaveData(SaveData saveData) {
        Account.saveData = saveData;
    }

    @Override
    public String toString() {
        return id + "\n" + username + "\n" + mail + "\n" + password + "\n" + location + "\n" + role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUserName(), getMail(), getPassword(), getLocation(), getRole());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getIdUser() == account.getIdUser() &&
                getUserName() == account.getUserName() &&
                getMail().equals(account.getMail()) &&
                getPassword().equals(account.getPassword()) &&
                getLocation().equals(account.getLocation()) &&
                getRole().equals(getRole()) &&
                getSaveData().equals(account.getSaveData());
    }
}