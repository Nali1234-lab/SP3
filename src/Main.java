import util.Fileio;
import util.TextUI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Opret værktøjerne
        TextUI textUI = new TextUI();
        Fileio fileIO = new Fileio();

        // 2. Opret data til Menu konstruktøren
        List<User> users = new ArrayList<>();
        List<Media> media = new ArrayList<>();
        User currentUser = null;

        // 3. Opret Menu objekt
        Menu menu = new Menu(users, media, currentUser, textUI, fileIO);

        // 4. Start programmet
        menu.start();
    }
}