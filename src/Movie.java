import util.TextUI;

import java.util.ArrayList;

public class Movie extends Media {
    private int duration;

    public Movie(String title, int releaseYear, double rating, ArrayList<Category> categories, int duration ) {
        super(title, releaseYear, rating, categories);
        this.duration=duration;
    }

    //override med textUI istedet for sout
    @Override
    public void play(TextUI textUI) {

    }

    @Override
    public void pause(TextUI textUI) {

    }

}
