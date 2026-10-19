package problem1;

public class Item {
    // member variables
    private String name;
    private double price;
    private int quantity;

    // contructor
    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // getters

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + "\t" + price + "$\t" + quantity + "\t" + (price * quantity) + "$";
    }
}
