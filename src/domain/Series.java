package domain;

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
        // domain.Series afspilningslogik - TextUI håndteres i domain.Menu
        System.out.println("Starter serie: " + title);
    }

    @Override
    public void pause() {
        // domain.Series pauselogik
        System.out.println("Serie på pause: " + title);
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }
}