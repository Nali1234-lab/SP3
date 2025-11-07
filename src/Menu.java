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


    public void start() {

    }

    public void showMenu() {

    }

    public void searchMedia() {

    }

}
