package domain;
//import util.TextUI;
import java.util.ArrayList;
import java.util.List;



public class User {
    private String username;              //  brugernavn
    private String password;              // adgangskode
    private List<Media> watchedMedia;     // Liste over set indhold
    private List<Media> savedMedia;
    //TextUI ui;// Liste over gemt indhold


    public User(String username, String password) {
        this.username = username;
        this.password = password;

        // Initialiser lister som tomme ArrayLists
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();
    }


    // Getters og setters (adgang til private attributter)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Media> getWatchedMedia() {
        return watchedMedia;
    }


    public List<Media> getSavedMedia() {
        return savedMedia;
    }
}


