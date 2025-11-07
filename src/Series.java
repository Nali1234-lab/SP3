import java.util.ArrayList;

public class Series extends Media {
    private ArrayList<Season> season= new ArrayList<>();
    public Series(String title, int releaseYear, double rating, ArrayList<Category> categories, ArrayList<Season> season) {
        super(title, releaseYear, rating, categories);
        this.season=season;

    }
}
