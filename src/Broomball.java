import objectdraw.FilledOval;
import objectdraw.FilledRect;
import objectdraw.Location;
import objectdraw.WindowController;

public class Broomball extends WindowController{

    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 600;
    public static final int SQUARE_SIDE = 30;
    public static final int BROOM_DIAMETER = 10;

    private FilledRect dirt;
    private FilledOval broom;

    public void begin(){

        dirt = new FilledRect((CANVAS_WIDTH / 2) - (SQUARE_SIDE / 2), (CANVAS_HEIGHT / 2) - (SQUARE_SIDE / 2), SQUARE_SIDE, SQUARE_SIDE, canvas);

        broom = new FilledOval(CANVAS_WIDTH, CANVAS_HEIGHT, BROOM_DIAMETER, BROOM_DIAMETER, canvas);

    }

    //CAN USE OVERLAPS METHOD!!!!!!
    public void onMouseDrag(Location point){

        double movement_increment = 1;
        broom.moveTo(point);

        //below if statement is for top of dirt square collision detection
        if ((broom.getX() >= dirt.getX() && ((broom.getX() + BROOM_DIAMETER) <= (dirt.getX() + SQUARE_SIDE))) &&
           (broom.getY() + BROOM_DIAMETER >= dirt.getY()) && ((broom.getY() + BROOM_DIAMETER) < (dirt.getY() + SQUARE_SIDE))) {

            dirt.move(0,movement_increment);
        }

        //below if statement is for left side of dirt square collision detection
        else if (((broom.getX() + BROOM_DIAMETER >= dirt.getX()) && (broom.getX() + BROOM_DIAMETER <= dirt.getX() + SQUARE_SIDE)) &&
                (broom.getY() >= dirt.getY() && (broom.getY() + BROOM_DIAMETER) <= (dirt.getY() + SQUARE_SIDE))) {

            dirt.move(movement_increment,0);
        }

        //below statement is for bottom side of dirt square collision detection
        else if ((broom.getX() >= dirt.getX()) && ((broom.getX() + BROOM_DIAMETER) <= (dirt.getX() + SQUARE_SIDE)) &&
                (broom.getY() <= (dirt.getY() + SQUARE_SIDE)) && (broom.getY() > dirt.getY())){

            dirt.move(0, -movement_increment);
        }

        //below statement is for right side of dirt square collision detection

        else if ((broom.getX() <= (dirt.getX() + SQUARE_SIDE) && (broom.getX() > dirt.getX())) &&
                (broom.getY() >= dirt.getY() && (broom.getY() + BROOM_DIAMETER) <= (dirt.getY() + SQUARE_SIDE))){

            dirt.move(-movement_increment,0);
        }

    }

    //on mouse exit, the dirt will go back to its original position in the center
    public void onMouseExit(Location point){

        dirt.moveTo((CANVAS_WIDTH / 2) - (SQUARE_SIDE / 2), (CANVAS_HEIGHT / 2) - (SQUARE_SIDE / 2));


    }

    public static void main(String[] args) {

        new Broomball().startController(CANVAS_WIDTH, CANVAS_HEIGHT);



    }
}
