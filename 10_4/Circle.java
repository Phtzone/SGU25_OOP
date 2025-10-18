import java.lang.Math;

public class Circle{
    private double radius;
    private String color;

    //Bo khoi tao
    public Circle(){
        this.radius = 1.0;
        this.color = "red";
        System.out.println("construced a Cricle with Circle()"); // de kiem tra
    }
    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
        System.out.println("Construced a Cricle with Circle(radius)");
    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
        System.out.println("Contruced a Cricle with Circle(radius, color)");
    }

    //phuong thuc getter vaf setter de lay thong tin thuoc tinh private
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }


// Mo ta thong tin doi tuong ... chuoi
    public String toString(){
        return "Circle[ radius" + radius + ", Color" + color + "]";
    }
    // tinh dien tich hinh tron
    public double getArea(){
        return radius * radius * Math.PI;
    }
}