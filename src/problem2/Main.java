package problem2;

public class Main {
    public static void main(String[] args){
        Bank bank = new Bank("National Bank");

        bank.addCustomer("Alice");
        bank.addCustomer("Bob");
        System.out.println("Duplicate Alice added: " + bank.addCustomer("Alice"));

        bank.addTransaction("Alice", 500.00);
        bank.addTransaction("Alice", -120.50);
        bank.addTransaction("Bob", 1000.00);
        System.out.println("Carol transaction added: " + bank.addTransaction("Carol", 50.00));

        bank.printStatement("Alice");
        bank.printStatement("Bob");
        bank.printStatement("Carol");
    }
}
