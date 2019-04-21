import java.util.Calendar;
import processing.core.*;
/**
 * Shapes is a subclass of Processing applet.
 *    -It will initialize the applet.
 *    -Shapes and text are drawn on the screen.
 *    -Mouse and keyboard input are read in.
 * Note: Adapted from Generative Gestaltung, ISBN: 978-3-87439-759-9
 */
public class Shapes extends PApplet {
    private static final int HEIGHT = 550;
    private static final int WIDTH = 550;

    /**
     * Launch the Processing Application.
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     * @param args - Program arguments are ignored.
     */
    public static void main(String args[]) {
        String packageFilename = "Shapes";
        PApplet.main(new String[] { packageFilename });
    }

    /**
     * Sets the Application Properties.
     */
    public void settings() {
        size(WIDTH,HEIGHT); // Set size of screen
    }

    /**
     * Called once per frame until program exits.
     */
    public void draw() {
    	// TODO 1: Replace SQUARE with ROUND
    	// TODO 2: Replace ROUND with PROJECT
        strokeCap(SQUARE);
        smooth();
        noFill();
        background(255);
        translate(width/2,height/2);

        int circleResolution = (int) map(mouseY, 0,height, 2,80);
        float radius = (float) (mouseX - width/2 + 0.5);
        float angle = TWO_PI/circleResolution;

        strokeWeight(mouseY/20);

        beginShape();
        for (int i=0; i<=circleResolution; i++){
            float x = cos(angle*i) * radius;
            float y = sin(angle*i) * radius;
            line(0, 0, x, y);
            // TODO 3: Add vertex(x, y);
        }
        endShape();
    }

    /**
     * Handle Key Press (Down)
     */
    public void keyPressed() {
        if (key=='s' || key=='S') saveFrame(timestamp()+"_##.png");
    }

    public String timestamp() {
        Calendar now = Calendar.getInstance();
        return String.format("%1$ty%1$tm%1$td_%1$tH%1$tM%1$tS", now);
    }
}
