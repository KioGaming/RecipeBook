package login;


import model.Dish;
import model.Playlist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class Wrapper {

    private static int id;
    private static String username;
    private static String mail;
    private static String password;
    private static String location;
    private static String role;
    List<Dish> dishes;
    List<Dish> like;
    List<Playlist> playlists;

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        Wrapper.id = id;
    }

    @XmlElement(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Wrapper.username = username;
    }

    @XmlElement(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        Wrapper.mail = mail;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Wrapper.password = password;
    }

    @XmlElement(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        Wrapper.location = location;
    }

    @XmlElement(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        Wrapper.role = role;
    }

    @XmlElement(name = "dishes")
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @XmlElement(name = "like")
    public List<Dish> getLike() {
        return like;
    }

    public void setLike(List<Dish> like) {
        this.like = like;
    }

    @XmlElement(name = "playlists")
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}

