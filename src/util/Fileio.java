package util;

import java.util.*;
import java.io.*;
import domain.User;

public class Fileio {
    private String movieFile = "Data/movies.txt";
    private String seriesFile = "Data/series.txt";
    private String userFile = "Data/userData.txt";


    public List<String> loadMovies() {
        try {
            File file = new File("Data/movies.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse linjen - f.eks. "The Godfather; 1972; Crime, Drama; 9,2;"
                String[] parts = line.split(";");

                String title = parts[0].trim();
                int year = Integer.parseInt(parts[1].trim());
                String[] genres = parts[2].trim().split(",");
                double rating = Double.parseDouble(parts[3].trim().replace(",", "."));

                // Opret Movie objekt og gem det i en liste
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet!");
        }
        return loadFile(movieFile);
    }


    public List<String> loadSeries() {
        return loadFile(seriesFile);
    }

    private List<String> loadFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Fejl: ikke fundet!!!1");
        }
        return lines;
    }

    //tilføjet loadUsers
    public List<User> loadUsers() {
        // Opretter en tom liste til at gemme alle brugerobjekterne
        List<User> userList = new ArrayList<>();

        try {
            // Åbner filen til læsning - BufferedReader læser tekst effektivt
            BufferedReader reader = new BufferedReader(new FileReader(userFile));

            // Deklarerer en variabel til at holde hver linje vi læser
            String line;

            // While-loop: Læser filen linje for linje indtil der ikke er flere linjer
            // reader.readLine() returnerer null når filen er slut
            while ((line = reader.readLine()) != null) {
                // Splitter linjen op ved kommaet - f.eks. "anna,1234" bliver til ["anna", "1234"]
                String[] parts = line.split(",");

                // Sikrer at linjen har mindst 2 dele (brugernavn + password)
                if (parts.length >= 2) {
                    // Opretter et nyt domain.User objekt med brugernavn (parts[0]) og password (parts[1])
                    User user = new User(parts[0], parts[1]);

                    // Tilføjer den nye bruger til vores liste
                    userList.add(user);
                }
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Fejl ved indlæsning af brugere: " + e.getMessage());
        }
        return userList;
    }

    // SAVE USERS - gem brugere til userData.txt
    public void saveUsers(List<User> users) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFile));

            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("Fejl ved gemning: " + e.getMessage());
        }
    }
}