package problem3;

public class Novel extends Book {
    private double price;

    public Novel(String title, String author, int nbrPages, double price) {
        super(title, author, nbrPages);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Novel: [" + super.toString() + ", price=" + price + "]";
    }
}