import java.util.ArrayList;

public class Season {
    private int seasonNumber;
    private ArrayList<Episode> episods= new ArrayList<>();

    public Season(int seasonNumber, ArrayList<Episode> episodes){
        this.seasonNumber= seasonNumber;
        this.episods= episodes;

    }


    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public ArrayList<Episode> getEpisods() {
        return episods;
    }

    public void setEpisods(ArrayList<Episode> episods) {
        this.episods = episods;
    }



}
