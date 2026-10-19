package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<Item>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine();

            // *** create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);

            // *** print the contents of the cart object using println
            double totalPrice = 0.0;

            System.out.println("\nShopping Cart");
            System.out.println("\nItem\tUnit Price\tQuantity\tTotal");

            for (int i = 0; i < cart.size(); i++)
            {
                Item current = cart.get(i);
                System.out.println(current);
                totalPrice += current.getPrice() * current.getQuantity();
            }

            System.out.println("\nTotal Price: " + totalPrice + "$\n");

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
