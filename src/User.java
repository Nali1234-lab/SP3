import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Media> watchedMedia;
    private List<Media> savedMedia;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();
    }

    public void login() {
        // Implementer senere
    }

    public void register() {
        // Implementer senere
    }

    public void addToWatched(Media media) {
        watchedMedia.add(media);
    }

    public void addToSaved(Media media) {
        savedMedia.add(media);
    }

    // Gettere
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<Media> getWatchedMedia() { return watchedMedia; }
    public List<Media> getSavedMedia() { return savedMedia; }
}
