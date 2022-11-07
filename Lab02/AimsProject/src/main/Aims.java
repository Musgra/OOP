package main;

public class Aims {

    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc disc = new DigitalVideoDisc("Haile");
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Haianh");
        disc.setCost(10);
        disc2.setCost(15);
        cart.addDigitalVideoDisc(disc);
        cart.addDigitalVideoDisc(disc2);
        cart.totalCost();
        cart.removeDigitalVideoDisc(disc);
        cart.totalCost();
        System.out.println(cart.totalCost());
    }
}
