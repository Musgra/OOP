package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.cart.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.cart.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Comparator;
import java.util.Scanner;

public class Aims {
    public static void showMenu() {

        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

    }
    public static void updateMenu(){
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Exit");
    }
    private static void filterMenu(){
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Exit");
    }
    private static void searchMenu(){
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) {
        showMenu();
        Store store = new Store();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    store.print();
                    int choice2;
                    do {
                        storeMenu();
                        choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter the title of media: ");
                                String title = sc.nextLine();
                                Media media = store.searchMedia(title);
                                if (media == null) {
                                    System.out.println("This item not exist");
                                    break;
                                }
                                int choice3;
                                do {
                                    mediaDetailsMenu();
                                    choice3 = sc.nextInt();
                                    switch (choice3) {
                                        case 1:
                                            cart.addMediaToCart(media);
                                            break;
                                        case 2:
                                            if (media instanceof Book) {
                                                System.out.println("Can't play");
                                            } else if (media instanceof CompactDisc) {
                                                ((CompactDisc) media).play();
                                            } else if (media instanceof DigitalVideoDisc) {
                                                ((DigitalVideoDisc) media).play();
                                            }
                                            break;
                                        case 0:
                                            break;
                                    }

                                }
                                while (choice3 != 0);


                                break;
                            case 2:
                                System.out.println("Enter the title of media: ");
                                String newLine = sc.nextLine();
                                title = sc.nextLine();
                                media = store.searchMedia(title);
                                if (media == null) {
                                    System.out.println("This item not exist");
                                    break;
                                }
                                cart.addMediaToCart(media);
                                System.out.println(cart.getTotalItem());

                                break;
                            case 3:
                                System.out.println("Enter the title of media: ");
                                title = sc.nextLine();
                                media = store.searchMedia(title);
                                if (media == null) {
                                    System.out.println("This item not exist");
                                    break;
                                }
                                if (media instanceof Book) {
                                    System.out.println("Can't play");
                                } else if (media instanceof CompactDisc) {
                                    ((CompactDisc) media).play();
                                } else if (media instanceof DigitalVideoDisc) {
                                    ((DigitalVideoDisc) media).play();
                                }

                                break;
                            case 4:
                                cart.printCart();
                                break;
                            case 0:
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                case 2:
                    updateMenu();
                    int choice4 ;
                    do {
                        choice4 = sc.nextInt();
                        switch (choice4) {
                            case 1:
                                break;
                        }
                    }

                    break;
                case 3:
                    cart.printCart();
                    cartMenu();
                    int choice5;
                    do {
                        choice5 = sc.nextInt();
                        switch (choice5){
                            case 1 :
                                filterMenu();
                                int choice6;

                                    choice6 = sc.nextInt();
                                    switch (choice6){
                                        case 1 :
                                            System.out.println("Enter id : ");
                                            String id = sc.nextLine();
                                            cart.searchDVDbyID(id);
                                            break;
                                        case 2 :
                                            System.out.println("Enter title : ");
                                            String title = sc.nextLine();
                                            cart.searchDVDbytitle(title);
                                            break;

                                    }
                                break;
                            case 2:
                                searchMenu();
                                int choice7;

                                choice7 = sc.nextInt();
                                switch (choice7){
                                    case 1 :
                                        Comparator comparator = new MediaComparatorByTitleCost();
                                        cart.sortCart(comparator);
                                        break;
                                    case 2 :
                                        Comparator comparator1 = new MediaComparatorByCostTitle();
                                        cart.sortCart(comparator1);
                                        break;
                                }while (choice7 != 0);
                            case 3:
                                System.out.println("Enter id : ");
                                String id = sc.nextLine();
                                Media media = cart.getMediaById(id);
                                if (media != null) {
                                    cart.removeMedia(media);
                                    break;
                                }
                                System.out.println("media not found");
                                break;
                            case 4:
                                System.out.println("Enter the title of media: ");
                                String title = sc.nextLine();
                                media = cart.searchMediabyTitle(title);
                                if (media == null) {
                                    System.out.println("This item not exist");
                                    break;
                                }
                                if (media instanceof Book) {
                                    System.out.println("Can't play");
                                } else if (media instanceof CompactDisc) {
                                    ((CompactDisc) media).play();
                                } else if (media instanceof DigitalVideoDisc) {
                                    ((DigitalVideoDisc) media).play();
                                }
                                break;
                            case 5:
                                System.out.println("Order has been created");
                                cart.emptyCart();
                                break;
                        }

                    }while (choice5 != 0);
                    break;
                case 0:
                    break;
            }
        }while (choice != 0);
    }
}
