package problem2;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName(){
        return name;
    }

    public boolean addCustomer(String customerName){
        if (findCustomer(customerName) == null){
            customers.add(new Customer(customerName));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount){
        Customer customer = findCustomer(customerName);
        if (customer == null){
            return false;
        }
        customer.addTransaction(amount);
        return true;
    }

    public void printStatement(String customerName){
        Customer customer = findCustomer(customerName);
        if (customer == null){
            System.out.println("Customer " + customerName + " not found.");
            return;
        }

        System.out.println("\nStatement for " + customer.getName() + " (" + name + ")");
        double balance = 0.0;

        for (Double transaction : customer.getTransactions()){
            double amount = transaction;  // unboxing
            String type = (amount >= 0) ? "Credit" : "Debit";
            System.out.printf("%s %.2f\n", type, amount);
            balance += amount;
        }
        System.out.printf("Balance: %.2f%n", balance);
    }

    private Customer findCustomer(String customerName){
        for (Customer c : customers)
        {
            if (c.getName().equalsIgnoreCase(customerName))
            {
                return c;
            }
        }
        return null;
    }
}
