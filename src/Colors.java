import java.util.Calendar;
import processing.core.*;
/**
 * Colors is a subclass of Processing applet.
 *    -It will initialize the applet.
 *    -Shapes and text are drawn on the screen.
 *    -Mouse and keyboard input are read in.
 * Note: Adapted from Generative Gestaltung, ISBN: 978-3-87439-759-9
 */
public class Colors extends PApplet {
    private static final int HEIGHT = 720;
    private static final int WIDTH = 720;

    /**
     * Launch the Processing Application.
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     * @param args - Program arguments are ignored.
     */
    public static void main(String args[]) {
        String packageFilename = "Colors";
        PApplet.main(new String[] { packageFilename });
    }

    /**
     * Sets the Application Properties.
     */
    public void settings() {
        size(WIDTH,HEIGHT); // Set size of screen
    }
    
    public void setup() {
        // TODO 1: Uncomment this. What happens?
        //noCursor();
    }

    /**
     * Called once per frame until program exits.
     */
    public void draw() {
        // TODO 2: Replace HSB with RGB
        colorMode(HSB, 360, 100, 100);
        rectMode(CENTER); 
        noStroke();
        background(mouseY/2, 100, 100);
        
        // TODO 3: try fill(100, 100, mouseY/2);
        fill(360-mouseY/2, 100, 100);
        // TODO 4: try ellipse(360, 360, 1.5*mouseX+1, mouseX+1);
        rect(360, 360, mouseX+1, mouseX+1);
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
