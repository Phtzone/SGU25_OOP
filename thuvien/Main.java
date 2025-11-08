package thuvien;

public class Main {
    public static void main(String[] args) {
        Book sach1;
        // create a single Author and wrap it in an Author[] as Book expects Author[]
        Author author = new Author("Phtzone", "pht@gmail.com", 'N');
        Author[] authors = new Author[] { author };

        sach1 = new Book("Tam Quoc", authors, 2000, 500);
        System.out.println("Ten Sach dau tien " + sach1.getName());
        System.out.println(sach1.getAuthors());
        System.out.println("Price: " + sach1.getPrice());
        System.out.println("GetQty: " + sach1.getQty());
        System.out.println(sach1);

        System.out.println("========================================");

        sach1.setPrice(5000);
        sach1.setQty(1000);
        System.out.println(sach1);
    }
}
