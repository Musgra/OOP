package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    public static final int MAX_LIMIT_ORDERED = 5;

    public float totalCost () {
        float cost = 0;
        for (int i = 0 ; i < itemsOrdered.size(); i++){
            cost += itemsOrdered.get(i).getCost();

        }

        return cost;
    }
    public int getTotalItem(){
        return itemsOrdered.size();
    }
    public void printCart(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0 ; i < itemsOrdered.size(); i++){
            System.out.println(itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public void addMediaToCart(Media media){
        for (int i = 0; i < itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).getId().equals(media.getId())){
                System.out.println("This item has been already added to Cart");
                return;
            }
        }
        itemsOrdered.add(media);
    }
    public void removeMedia(Media media){
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId().equals(media.getId())) {
                itemsOrdered.remove(media);
                return;
            }
        }
            System.out.println("Item is not in the cart");
    }
    public void searchDVDbyID(String id){
        for (int i = 0 ; i < itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).getId().equals(id)){
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("no match is found.");
    }
    public void searchDVDbytitle(String title){
        for (int i = 0 ; i < itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).isMatch(title)){
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("no match is found.");
    }

    public Media getMediaById(String id) {
        for (int i = 0 ; i < itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).getId().equals(id)){
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
    public Media searchMediabyTitle(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
    public void sortCart(Comparator comparator){
        this.itemsOrdered.sort(comparator);
    }
    public void emptyCart(){
        itemsOrdered = new ArrayList<Media>();
    }

}
