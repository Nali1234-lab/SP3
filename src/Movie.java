import java.util.ArrayList;

public class Movie extends Media {
    private int duration;

    public Movie(String title, int releaseYear, double rating, ArrayList<Category> categories, int duration ) {
        super(title, releaseYear, rating, categories);
        this.duration=duration;
    }
    @Override
    public void play() {
        System.out.println("Playing movie: " + title); //den skal ændret vha. textUI...
    }

    @Override
    public void pause() {
        System.out.println("Movie paused: " + title);// den skal ændret vha. textUI...
    }
}
