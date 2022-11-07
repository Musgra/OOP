package main;

public class Cart {

    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered =
            new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBER_ORDERED){
            System.out.println("The cart is almost full");
        }else{
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        DigitalVideoDisc newItemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        for (int i = 0, k = 0;i < qtyOrdered; i++){
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())){
                continue;
            }
            newItemsOrdered[k++] = itemsOrdered[i];

        }
        qtyOrdered--;
        itemsOrdered = newItemsOrdered;
    }

    public float totalCost () {
        float cost = 0;
        for (int i = 0;i < qtyOrdered; i++){
            System.out.println(itemsOrdered[i].getTitle());
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}
