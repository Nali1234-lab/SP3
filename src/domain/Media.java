package domain;

import java.util.ArrayList;

public abstract class Media {
    protected static String title;
    protected int releaseYear;
    protected double rating;
    protected ArrayList<Category> categories = new ArrayList<>();

    public Media(String title, int releaseYear, double rating, ArrayList<Category> categories){
        this.title= title;
        this.releaseYear=releaseYear;
        this.rating= rating;
        this.categories=  categories;
    }


    public static String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public abstract void play();

    public abstract void pause();
}
