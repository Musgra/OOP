package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public Media searchMedia(String title){
        for(int i = 0;i < itemsInStore.size();i++){
            if(itemsInStore.get(i).getTitle().equals(title)){
                System.out.println(itemsInStore.get(i));
                return itemsInStore.get(i);
            }
        }
        return null;
    }

    public void addMedia(Media media){
        itemsInStore.add(media);
    }
    public void removeMedia(Media media){
        itemsInStore.remove(media);
    }


    public void print() {
        for (Media dvd : itemsInStore) {
            System.out.println(dvd);
        }

    }
}