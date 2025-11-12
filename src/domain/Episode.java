package domain;

public class Episode {
    private String title;
    private int duration;
    public Episode(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }




    public void play() {
        System.out.println("Playing episode: " + title);// bruge textui. senere

    }

    public void pause() {
        System.out.println("domain.Episode paused: " + title); // bruge textui. senere
    }



}
