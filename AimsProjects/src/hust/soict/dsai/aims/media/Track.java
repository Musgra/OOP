package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    public boolean equals(Track track){
        if (this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength()){
            return true;
        }
        return false;
    }
}
