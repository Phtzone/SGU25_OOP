package 2510;

public class Square extends Rectangle {
    private double side;

    public Square(double side){
        this.side= side;
    }

    public Square(double side, String color, Boolean filled){
        this.side = side;
        this.color = color;
        this.filled = filled;
    }

    public void setSide(double side){
        this.side = side;
    }

    public double getSide(){
        return side;
    }

    public double getArea(){

    }

    public double getPerimeter(){

    }

    public String toString(){
        
    }
}
