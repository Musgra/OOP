package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

//    public Book(String title, String category) {
//        super(title, category);
//    }
//
//    public Book(String id, String title, String category, float cost, List<String> authors) {
//        super(title, category, cost, id);
//        this.authors = authors;
//    }

//    public Book(Book book) {
//        super(book.getTitle(), book.getCategory(), book.getCost(), book.getId());
//        this.authors = book.getAuthors();
//    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthors(String authorName) {
        if(authors.contains(authorName)) {
            System.out.println("Author is already in the list");
            return ;
        }
        System.out.println(authorName +"add");
        authors.add(authorName);
        System.out.println("Successfully added new author.");
    }

    public void removeAuthors(String authorName) {
        if(!authors.contains(authorName)) {
            System.out.println("Author is not in the list.");
            return;
        }
        authors.remove(authorName);
    }
}
