package domain;

import util.Fileio;
import util.TextUI;

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
// start() - starter hele programmet
    public void start() {
        ui.showMessage("Velkommen til Streaming Menuen.");

        // INDLÆS brugere fra fil
        users = fileIO.loadUsers();
        ui.showMessage("Indlæste " + users.size() + " brugere fra filen.");

        boolean loggedIn = false;

        // Loop indtil brugeren er logget ind
        while (!loggedIn) {
            ui.showMessage("\n  VÆLG EN MULIGHED ");
            ui.showMessage("1. Login");
            ui.showMessage("2. Registrer ny bruger");
            ui.showMessage("3. Afslut");

            String choice = ui.getUserInput("Vælg (1-3): ");

            switch (choice) {
                case "1":
                    login();
                    if (currentUser != null) {
                        loggedIn = true;
                    }
                    break;

                case "2":
                    register();
                    ui.showMessage("Du kan nu logge ind med din nye bruger!");
                    break;

                case "3":
                    ui.showMessage("Gemmer data...");
                    fileIO.saveUsers(users);  // GEM brugere før afslutning
                    ui.showMessage("Farvel!");
                    return;

                default:
                    ui.showMessage("Ugyldigt valg!");
            }
        }

        // Når brugeren er logget ind, vis hovedmenuen
        showMenu();

        // GEM brugere når brugeren logger ud
        ui.showMessage("Gemmer data...");
        fileIO.saveUsers(users);
    }

    // Register metode til oprettelse af ny bruger
    public void register() {
        // 1. Få brugernavn fra brugeren
        String username = ui.promptForUsername();

        // 2. Tjek om brugernavnet allerede findes
        for (User user : users) {  // Gennemgå alle eksisterende brugere
            if (user.getUsername().equals(username)) {  // Hvis navnet findes
                ui.showMessage("Brugernavnet er allerede taget!");
                return;  // Stop metoden her
            }
        }

        // 3. Få password fra brugeren
        String password = ui.promptForPassword();

        // 4. Opret ny bruger
        User newUser = new User(username, password);

        // 5. Tilføj brugeren til listen
        users.add(newUser);

        // 6. Bekræft oprettelsen
        ui.showMessage("Bruger '" + username + "' er nu oprettet!");
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
