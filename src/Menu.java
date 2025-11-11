import util.Fileio;
import util.TextUI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //attributter
    private List<User> users;
    private List<Media> media;
    private User currentUser;

    private TextUI ui;
    private Fileio fileIO;

    //constructor
    public Menu(List<User> users, List<Media> media, User currentUser, TextUI ui, Fileio fileIO) {
        this.users = users;
        this.media = media;
        this.currentUser = currentUser;
        this.ui = ui;
        this.fileIO = fileIO;
    }


    // start() - starter hele programmet
    public void start() {
        ui.showMessage("Velkommen til Streaming Menuen.");
        // kun til at teste password.
        User testUser = new User("test", "123");
        users.add(testUser);

        // Login først
        login();

        // Hvis login lykkedes, vis menu
        if (currentUser != null) {
            showMenu();
        }
    }

        // login() - logger brugeren ind
        private void login() {
            String username = ui.promptForUsername();
            String password = ui.promptForPassword();

            // Tjek om brugernavn og password matcher
            for (User user : users) { // Gennemgå alle users
                if (user.getUsername().equals(username) &&
                        user.getPassword().equals(password)) {
                    currentUser = user;
                    ui.showMessage("Login succesfuldt!");
                    return;
                }
            }

            ui.showMessage("Forkert login!");
        }

        // showMenu() - viser hovedmenuen
        public void showMenu() {
            boolean running = true;

            while (running) { // Gentag indtil bruger logger ud
                // Vis valgmuligheder
                ui.showMessage("\n1. Søg film");
                ui.showMessage("2. Søg kategori");
                ui.showMessage("3. Mine sete film");
                ui.showMessage("4. Mine gemte film");
                ui.showMessage("5. Log ud");

                String choice = ui.getUserInput("Vælg en mulighed (1-5):");

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
            String searchTitle = ui.getUserInput("\nIndtast titel: ");

            boolean found = false;

            // 1. Søg i media listen (film OG serier)
            for (Media m : media) {
                if (m.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                    ui.showMessage("Fundet: " + m.getTitle());
                    found = true;
                }
            }

            // 2. Søg i FileIO movies
            List<String> movieLines = fileIO.loadMovies();
            for (String movieLine : movieLines) {
                if (movieLine.toLowerCase().contains(searchTitle.toLowerCase())) {
                    ui.showMessage("Fundet film: " + movieLine.split(";")[0]);
                    found = true;
                }
            }

            // 3. Søg i FileIO series
            List<String> seriesLines = fileIO.loadSeries();
            for (String seriesLine : seriesLines) {
                if (seriesLine.toLowerCase().contains(searchTitle.toLowerCase())) {
                    ui.showMessage("Fundet serie: " + seriesLine.split(";")[0]);
                    found = true;
                }
            }

            if (!found) {
                ui.showMessage("Ingen film eller serier fundet med '" + searchTitle + "'");
            }
        }


        // searchByCategory() - søger film i en kategori
        private void searchByCategory() {
            String category = ui.getUserInput("Vælg medie kategori: ");

            // Vis alle film i den kategori
            for (Media m : media) {
                // Tjek om filmen har denne kategori
                ui.showMessage(m.getTitle());
            }
        }

        // showWatchedMedia() - viser brugerens sete film
        private void showWatchedMedia() {
            ui.showMessage("Dine sete film: ");

            for (Media m : currentUser.getWatchedMedia()) {
                ui.showMessage("- " + m.getTitle());
            }
        }

        // showSavedMedia() - viser brugerens gemte film
        private void showSavedMedia() {
            ui.showMessage("Dine gemte film: ");

            for (Media m : currentUser.getSavedMedia()) {
                ui.showMessage("- " + m.getTitle());
            }
        }


}
