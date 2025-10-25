package 2510;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, Boolean filled){
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public String toString(){

    }
}
