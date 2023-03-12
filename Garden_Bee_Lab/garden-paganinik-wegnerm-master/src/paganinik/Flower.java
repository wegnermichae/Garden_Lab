package paganinik;

public abstract class Flower {
    private double x;
    private double y;

    public Flower(){
        this.x = (Math.random() * 550); //random x position for flowers anywhere along the window length
        this.y = 500; // set y position for flowers so they stay along the bottom of the window
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}