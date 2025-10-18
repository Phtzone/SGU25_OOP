public class Cylinder extends Circle{
    // cac thuoc tinh co muc do truy cap vao private
    private double height;

    // bo khoi tao
    public Cylinder(){
        super(); // goi bo khoi tao cua lop cha Circle()
        this.height = 1.0;
        System.out.println("Constructed a Cylinder with Cylinder()");
    }

    public Cylinder(double height){
        super(); // goi bo khoi tao cua lop cha Circle()
        this.height = height;
        System.out.println("Constructed a Cylinder with Cylinder(height)");
    }

    public Cylinder(double height, double radius){
        super(radius); // goi bo khoi tao cho Circle()
        this.height = height;
        System.out.println("Constructed a Cylinder with Cylinder(height, radius)");
    }

    public Cylinder(double height, double radius, String color){
        super(radius, color); // goi bo khoi tao lop cha Circle(radius, color)
        this.height = height;
        System.out.println("constructed a Cylinder with Cylinder(height, radius, color)");
    }

    // Phuong thuc cong khai getter va setter de lay thong tin thuoc tinh private
    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    // tinh kho luong hinh tron
    public double getVolume(){
        return getArea() * height; // co dong phuong thuc getAraa()
    }

    //mo ta thong tin doi tuong dang chuoi
    public String toString(){
        return "this is a Cylinder"; // xem doan vi du sau
    }

    //  tinh dien tich toan phan hinh tru
    public double getTotalArea(){
        return ( 2 * Math.PI * getRadius() * height) + 2 * getArea();
    }
}