package paganinik;

public class DestroyerBee extends Bee{

    private boolean moveRight = false;
    private boolean moveUp = false;




    @Override
    public void moveBee() {
            double x = this.getX();
            double y = this.getY();

            if(moveRight && x < MAX_WIDTH){
                this.setX(x + 10);
            }
            else if (moveRight && x > MAX_WIDTH){
                this.setX(x - 10);
                moveRight = false;
            }
            else if (!moveRight && x > 50){
                this.setX(x - 10);
            }
            else if (!moveRight && x < 50){
                this.setX(x + 10);
                moveRight = true;
            }

            if(moveUp && y < MAX_HEIGHT){
                this.setY(y + 5);

            }
            else if (moveUp && y > MAX_HEIGHT){
                this.setY(y - 5);
                moveUp = false;
            }
            else if (!moveUp && y > 50){
                this.setY(y - 5);
            }
            else if(!moveUp && y < 50){
                this.setY(y + 5);
                moveUp = true;
            }

    }
}
