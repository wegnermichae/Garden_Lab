package paganinik;




public abstract class Bee {


    private int health;
    private double x;
    private double y;
    public int MAX_WIDTH = 550;
    public int MAX_HEIGHT = 550;


    public Bee() {
        this.health = (int) Math.random() * 50;
        this.x =  (Math.random() * 550);
        this.y = (Math.random() * 550);


    }
    public abstract void moveBee();

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double X){
        this.x = X;
    }
    public void setY(double Y){
        this.y = Y;
    }

}
