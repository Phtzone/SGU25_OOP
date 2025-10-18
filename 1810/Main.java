public class Main {
    public static void main(String[] args){
    Point p = new Point();
    System.out.println("Point ban đầu: "+ p);
    
    p.setXY(3.0f,4.0f);
    System.out.println("point sau khi setXY: " + p);

    MovablePoint mp = new MovablePoint(2.0f, 3.0f, 0.5f, 3.0f);
    System.out.println("MovablePoint ban đầu: " + mp);
    mp.move();
    System.out.println("Move lần 1: " + mp);
    //mp.move();
    //System.out.println("Move lần 2: " + mp);

    mp.setSpeed(-1.0f,0.0f);
    mp.move();
    System.out.println("sau khi doi speed và move: " + mp);
    }
}
