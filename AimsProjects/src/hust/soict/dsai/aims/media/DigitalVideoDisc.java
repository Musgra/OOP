package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, length, director);
    }

    public boolean search(String title) {
        String[] tokens = title.split(" ");
        for (String token : tokens) {
            if (!this.getTitle().contains(token)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
