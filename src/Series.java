import util.TextUI;
import java.util.ArrayList;

public class Series extends Media {
    private ArrayList<Season> season= new ArrayList<>();
    public Series(String title, int releaseYear, double rating, ArrayList<Category> categories, ArrayList<Season> season) {
        super(title, releaseYear, rating, categories);
        this.season=season;

    }

    @Override
    public void play(TextUI textUI) {
        textUI.showMessage("Afspiller serie: " + title);
    }

    @Override
    public void pause(TextUI textUI) {
        textUI.showMessage("Serie sat på pause: " + title);
    }

    public ArrayList<Season> getSeasons() {
        return season;
    }
}

