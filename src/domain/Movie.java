package domain;

import java.util.ArrayList;

public class Movie extends Media {
    private int duration;

    public Movie(String title, int releaseYear, double rating,
                 ArrayList<Category> categories, int duration) {
        super(title, releaseYear, rating, categories);
        this.duration = duration;
    }

    @Override
    public void play() {
        // domain.Movie afspilningslogik her
        System.out.println("Afspiller film: " + title);
    }

    @Override
    public void pause() {
        // domain.Movie pauselogik her
        System.out.println("Film på pause: " + title);
    }
}