import util.TextUI;
import java.util.ArrayList;

public class Series extends Media {
    private ArrayList<Season> seasons = new ArrayList<>();  // seasons (flertal)

    public Series(String title, int releaseYear, double rating,
                  ArrayList<Category> categories, ArrayList<Season> seasons) {
        super(title, releaseYear, rating, categories);
        this.seasons = seasons;
    }

    @Override
    public void play() {
        // Series afspilningslogik - TextUI håndteres i Menu
        System.out.println("Starter serie: " + title);
    }

    @Override
    public void pause() {
        // Series pauselogik
        System.out.println("Serie på pause: " + title);
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }
}