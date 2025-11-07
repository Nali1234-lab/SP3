import java.util.ArrayList;

public abstract class Media {
    protected String title;
    protected int releaseYear;
    protected double rating;
    protected ArrayList<Category> categories = new ArrayList<>();

    public Media(String title, int releaseYear, double rating, ArrayList<Category> categories){
        this.title= title;
        this.releaseYear=releaseYear;
        this.rating= rating;
        this.categories=  categories;
    }

    public void play(){

    }

    public void pause(){

    }
}
