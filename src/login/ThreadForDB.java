package login;

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

    public ThreadForDB(String command, String mail, String password) {
        this.command = command;
        this.mail = mail;
        this.password = password;
    }

    public ThreadForDB(String command, String mail, String password, String username, String location) {
        this.command = command;
        this.mail = mail;
        this.password = password;
        this.username = username;
        this.location = location;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            socket.setSoTimeout(10000);
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
            //Отправка запроса
            if (command.equals("signUp")) {
                toServer.println(command + "/" + username + "/" + mail + "/" + password + "/" + location);
            } else if (command.equals("signIn") || command.equals("getRecipe")) {
                toServer.println(command + "/" + mail + "/" + password);
            }
            PrintWriter outFile = new PrintWriter("D:/account.rb");
            Scanner scanner = new Scanner(socket.getInputStream());
            switch (command) {
                case "signIn":
                case "signUp":
                    while (scanner.hasNextLine()) {
                        outFile.write(scanner.nextLine() + "\n");
                    }
                    scanner.close();
                    outFile.close();
                    SaveLoadRemote.loadInXML(22);
                    break;
                case "getRecipe":

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}