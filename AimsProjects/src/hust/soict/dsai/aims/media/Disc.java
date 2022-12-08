package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private final int length;
    private final String director;

    public Disc(String id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
