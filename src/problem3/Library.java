package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<Document>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (Document d : documents) {
            System.out.println(d);
        }
    }

    public boolean add(Document doc) {
        if (doc == null || documents.size() >= capacity || documents.contains(doc)) {
            return false;
        }
        return documents.add(doc);
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numRec) {
        for (Document d : documents) {
            if (d.getNumRec() == numRec) {
                return d;
            }
        }
        return null;
    }

    public void displayAuthors() {
        boolean found = false;
        for (Document d : documents) {
            if (d instanceof Book) {
                System.out.println(((Book) d).getAuthor() + " - " + d.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No documents with an author.");
        }
    }
}