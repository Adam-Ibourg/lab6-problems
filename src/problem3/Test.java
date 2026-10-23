package problem3;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the library capacity (at least 2): ");
            n = scan.nextInt();
        } while (n < 2);

        Library library = new Library(n);
        library.add(new Novel("Les Miserables", "Victor Hugo", 1488, 19.99));
        library.add(new Magazine("National Geographic", "March", 2024));

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add a document");
            System.out.println("2. Display all documents");
            System.out.println("3. Delete a document");
            System.out.println("4. Search a document by record number");
            System.out.println("5. Display authors");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addDocument(library, scan);
                    break;
                case 2:
                    library.displayDocuments();
                    break;
                case 3:
                    System.out.print("Record number to delete: ");
                    Document toDelete = library.document(scan.nextInt());
                    System.out.println(library.delete(toDelete) ? "Document deleted." : "Document not found.");
                    break;
                case 4:
                    System.out.print("Record number to search: ");
                    Document found = library.document(scan.nextInt());
                    System.out.println(found != null ? found : "Document not found.");
                    break;
                case 5:
                    library.displayAuthors();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addDocument(Library library, Scanner scan) {
        System.out.println("1. Novel  2. Textbook  3. Magazine  4. Dictionary");
        System.out.print("Select the type of document: ");
        int type = scan.nextInt();
        scan.nextLine();

        if (type < 1 || type > 4) {
            System.out.println("Invalid type.");
            return;
        }

        System.out.print("Title: ");
        String title = scan.nextLine();
        Document doc;

        if (type == 1) {
            System.out.print("Author: ");
            String author = scan.nextLine();
            System.out.print("Pages: ");
            int pages = scan.nextInt();
            System.out.print("Price: ");
            double price = scan.nextDouble();
            doc = new Novel(title, author, pages, price);
        } else if (type == 2) {
            System.out.print("Author: ");
            String author = scan.nextLine();
            System.out.print("Pages: ");
            int pages = scan.nextInt();
            scan.nextLine();
            System.out.print("Level: ");
            String level = scan.nextLine();
            doc = new Textbook(title, author, pages, level);
        } else if (type == 3) {
            System.out.print("Month: ");
            String month = scan.nextLine();
            System.out.print("Year: ");
            int year = scan.nextInt();
            doc = new Magazine(title, month, year);
        } else {
            System.out.print("Language: ");
            String language = scan.nextLine();
            doc = new Dictionary(title, language);
        }

        System.out.println(library.add(doc) ? "Document added." : "Could not add (library full).");
    }
}