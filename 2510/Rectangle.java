package 2510;

public class Rectangle extends Shape {
    private double width, length;

    public Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, Boolean filled){
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }
    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getLength(){
        return length;
    }
    
    public double getArea(){

    }

    public double getPerimeter(){

    }
        public String toString(){
        
    }
}
