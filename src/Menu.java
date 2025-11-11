import util.Fileio;
import util.TextUI;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    //attributter
    private List<User> users;
    private List<Media> media;
    private User currentUser;

    private TextUI textUI;
    private Fileio fileIO;

    //constructor
    public Menu(TextUI textUI, Fileio fileIO) {
        this.users = new ArrayList<>();
        this.media = new ArrayList<>();

        this.textUI = new TextUI();
        this.fileIO = new Fileio();

        this.currentUser = null; //null fordi bruger ikke er logget ind endnu
    }


    // start() - starter hele programmet
    public void start() {
        textUI.showMessage("Velkommen til Streaming Menuen.");

        // Login først
        login();

        // Hvis login lykkedes, vis menu
        if (currentUser != null) {
            showMenu();
        }
    }

        // login() - logger brugeren ind
        private void login() {
            String username = textUI.promptForUsername();
            String password = textUI.promptForPassword();

            // Tjek om brugernavn og password matcher
            for (User user : users) { // Gennemgå alle users
                if (user.getUsername().equals(username) &&
                        user.getPassword().equals(password)) {
                    currentUser = user;
                    textUI.showMessage("Login succesfuldt!");
                    return;
                }
            }

            textUI.showMessage("Forkert login!");
        }

        // showMenu() - viser hovedmenuen
        public void showMenu() {
            boolean running = true;

            while (running) { // Gentag indtil bruger logger ud
                // Vis valgmuligheder
                textUI.showMessage("\n1. Søg film");
                textUI.showMessage("2. Søg kategori");
                textUI.showMessage("3. Mine sete film");
                textUI.showMessage("4. Mine gemte film");
                textUI.showMessage("5. Log ud");

                String choice = textUI.getUserInput();

                // Hvad skal der ske?
                switch (choice) {
                    case "1" -> searchMedia();
                    case "2" -> searchByCategory();
                    case "3" -> showWatchedMedia();
                    case "4" -> showSavedMedia();
                    case "5" -> running = false;  // Stop loopet
                }
            }
        }

        // searchMedia() - søger efter en specifik film
        public void searchMedia() {
            textUI.showMessage("\nIndtast filmtitel: ");
            String searchTitle = textUI.getUserInput();

            // Find film der matcher søgningen
            for (Media m : media) { //Gennemgå alle film
                if (m.getTitle().contains(searchTitle)) { // Hvis titlen matcher
                    textUI.showMessage("Fundet: " + m.getTitle());  // Vis filmen
                }
            }
        }

        // searchByCategory() - søger film i en kategori
        private void searchByCategory() {
            textUI.showMessage("Vælg medie kategori: ");
            String category = textUI.getUserInput();

            // Vis alle film i den kategori
            for (Media m : media) {
                // Tjek om filmen har denne kategori
                textUI.showMessage(m.getTitle());
            }
        }

        // showWatchedMedia() - viser brugerens sete film
        private void showWatchedMedia() {
            textUI.showMessage("Dine sete film: ");

            for (Media m : currentUser.getWatchedMedia()) {
                textUI.showMessage("- " + m.getTitle());
            }
        }

        // showSavedMedia() - viser brugerens gemte film
        private void showSavedMedia() {
            textUI.showMessage("Dine gemte film: ");

            for (Media m : currentUser.getSavedMedia()) {
                textUI.showMessage("- " + m.getTitle());
            }
        }
}
