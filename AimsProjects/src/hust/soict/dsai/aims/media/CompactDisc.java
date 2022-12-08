package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{

    private final String artist;
    private final ArrayList<Track> Tracks = new ArrayList<>();

    public CompactDisc(String id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        for (Track item : Tracks) {
            if (track.getTitle().equals(item.getTitle())) {
                System.out.println("Track is already in the list.");
                return;
            }
        }

        Tracks.add(track);
    }

    public void removeTrack(Track track) {
        for (Track item : Tracks) {
            if (track.getTitle().equals(item.getTitle())) {
                Tracks.remove(item);
                return;
            }
        }

        System.out.println("Track is not in the list.");
    }

    public int getLength() {
        int sum = 0;
        for (Track track : Tracks) {
            sum += track.getLength();
        }

        return sum;
    }

    public void play() {
        System.out.println(this.getTitle() + " - " + this.getArtist());
        for (Track track : Tracks) {
            track.play();
        }
    }
}
