import util.TextUI;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;              //  brugernavn
    private String password;              // adgangskode
    private List<Media> watchedMedia;     // Liste over set indhold
    private List<Media> savedMedia;
    TextUI ui;// Liste over gemt indhold



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



    //Login metode - tjekker om password matcher

    public boolean login(String inputPassword) {
        // Sammenlign password med brugerens password
        if (this.password.equals(inputPassword)) {
            System.out.println("Login succesfuldt! Velkommen, " + username);
            return true;
        } else {
            System.out.println("Forkert password. Prøv igen");
            return false;
        }
    }

    //Register metode til oprettelse af ny bruger

    public void register() {
        System.out.println("Bruger '" + username + "' er nu oprettet!");
    }

    //Tilføj media til "set" listen

    public void addToWatched(Media media) {

        // Tjek media allerede er i listen?

        if (!watchedMedia.contains(media)) {
            watchedMedia.add(media);
            System.out.println( media.getTitle() + "' tilføjet til set liste");
        } else {
            System.out.println( media.getTitle() + "' er allerede i din set liste");
        }
    }

    //Tilføj media til "gemt" listen

    public void addToSaved(Media media) {
        // Tjek media allerede er i listen?

        if (!savedMedia.contains(media)) {
            savedMedia.add(media);
            System.out.println( media.getTitle() + "' gemt til senere");
        } else {
            System.out.println(media.getTitle() + "' er allerede gemt");
        }
    }

    //Fjern media fra set listen

    public void removeFromWatched(Media media) {
        if (watchedMedia.remove(media)) {
            System.out.println( media.getTitle() + "' fjernet fra set liste");
        } else {
            System.out.println(media.getTitle() + "' var ikke i din set liste");
        }
    }

    //Fjern media fra "gemt" listen


    public void removeFromSaved(Media media) {
        if (savedMedia.remove(media)) {
            System.out.println( media.getTitle() + "' fjernet fra gemt liste");
        } else {
            System.out.println( media.getTitle() + "' var ikke i din gemt liste");
        }
    }

    //Vis brugerens set liste

    public void showWatchedMedia() {
        ui.showMessage("\n=== " + username + "'s Set Indhold ===");
        if (watchedMedia.isEmpty()) {
            ui.showMessage("Du har ikke set noget endnu.");
        } else {
            for (int i = 0; i < watchedMedia.size(); i++) {
                ui.showMessage((i + 1) + ". " + watchedMedia.get(i).getTitle());
            }
        }
    }

    // Vis brugerens gemte indhold

    public void showSavedMedia() {
        ui.showMessage("\n=== " + username + "'s Gemte Indhold ===");
        if (savedMedia.isEmpty()) {
            ui.showMessage("Du har ikke gemt noget endnu.");
        } else {
            for (int i = 0; i < savedMedia.size(); i++) {
                ui.showMessage((i + 1) + ". " + savedMedia.get(i).getTitle());
            }
        }
    }



    // TOSTRING - For at printe User objektet pænt

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", watchedMedia=" + watchedMedia.size() + " items" +
                ", savedMedia=" + savedMedia.size() + " items" +
                '}';
    }
}