package login;

import saveload.SaveData;

public class Account{

    private String username;
    private String mail;
    private String password;
    private String location;
    private SaveData saveData;

    public Account(String username, String mail, String password, String location) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.location = location;
        this.saveData = new SaveData();
    }

    public void save() {
        saveData.save(username);
    }

    public void load() {
        saveData.load(username);
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SaveData getSaveData(){
        return this.saveData;
    }

    public void setSaveData(SaveData saveData) {
        this.saveData = saveData;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return username + " " + mail + " " + password + " " + location;//+ " " + saveData.toString();
    }
}
