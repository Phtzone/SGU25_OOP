package thuvien;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = new Author[authors.length];
        for (int index = 0; index < authors.length; index++)
            this.authors[index] = new Author(authors[index].getName(), authors[index].getEmail(),
                    authors[index].getGender());
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = new Author[authors.length];
        for (int index = 0; index < authors.length; index++)
            this.authors[index] = new Author(authors[index].getName(), authors[index].getEmail(),
                    authors[index].getGender());
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[name = " + name + ",price= " + price + ", qty = " + qty + "] ";
    }

    public String getAuthorNames() {
        String result = "";
        for (int index = 0; index < this.authors.length - 1; index++) {
            result += this.authors[index].getName();
            result += ", ";
        }
        result += this.authors[this.authors.length - 1].getName();
        return result;
    }
}