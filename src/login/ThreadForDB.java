package login;

import settings.Settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static settings.Settings.SERVER_HOST;
import static settings.Settings.SERVER_PORT;

public class ThreadForDB implements Runnable {

    String mail;
    String password;
    String command;
    String username;
    String location;
    int arg1, arg2;
    String arg3;

    public ThreadForDB(String command, String mail, String password) {
        this.command = command;
        this.mail = mail;
        this.password = password;
    }

    public ThreadForDB(String command, String username, String mail, String password, String location) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.username = username;
        this.location = location;
    }

    public ThreadForDB(String command, String mail, String password, int arg1, int arg2) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public ThreadForDB(String command, String mail, String password, int arg1, String arg3) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.arg1 = arg1;
        this.arg3 = arg3;
    }

    public ThreadForDB(String command, String mail, String password, String arg3) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.arg3 = arg3;
    }

    public ThreadForDB(String command, String mail, String password, int arg1) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.arg1 = arg1;
    }

    public ThreadForDB(String command, String username, String mail, boolean b) {
        this.command = command;
        this.mail = mail;
        this.username = username;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            socket.setSoTimeout(10000);
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
            //Отправка запроса
            switch (command) {
                case "signUp":
                    toServer.println(command + "/" + username + "/" + mail + "/" + password + "/" + location);
                    break;
                case "signIn":
                    toServer.println(command + "/" + mail + "/" + password);
                    break;
                case "addDishInPlaylist":
                case "removeDishInPlaylist":
                case "removeLikedDishes":
                case "saveLikedDishes":
                    toServer.println(command + "/" + mail + "/" + password + "/" + arg1 + "/" + arg2);
                    break;
                case "removePlaylist":
                case "addOneLike":
                case "removeOneLike":
                case "sendMail":
                    toServer.println(command + "/" + mail + "/" + password + "/" + arg1);
                    break;
                case "addPlaylist":
                    toServer.println(command + "/" + mail + "/" + password + "/" + arg1 + "/" + arg3);
                    break;
                case "changePassword":
                case "changeUsername":
                case "changeLocation":
                    toServer.println(command + "/" + mail + "/" + password + "/" + arg3);
                    break;
                case "verifyNoUsedUsernameOrMail":
                    toServer.println(command + "/" + username + "/" + mail);
                    break;
            }
            //Прийом ответа
            PrintWriter outFile = new PrintWriter(System.getenv("APPDATA") + "/recipebook/account.rb");
            Scanner scanner = new Scanner(socket.getInputStream());
            switch (command) {
                case "signIn":
                case "signUp":
                    int i = 0;
                    while (scanner.hasNextLine()) {
                        outFile.write(scanner.nextLine() + "\n");
                        i++;
                    }
                    scanner.close();
                    outFile.close();
                    if (i > 0) {
                        SaveLoadRemote.loadInXML();
                    }
                    break;
                case "addPlaylist":
                    if (scanner.hasNextLine()) {
                        String k = scanner.nextLine();
                        Settings.idPlaylistTemp = Integer.parseInt(k);
                    }
                    scanner.close();
                    outFile.close();
                    break;
                case "verifyNoUsedUsernameOrMail":
                    if (scanner.hasNextLine()) {
                        String k = scanner.nextLine();
                        System.out.println(k);
                        Settings.verifyNoUsedUsernameOrMailTemp = k.equals("true");
                    }
                    scanner.close();
                    outFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}