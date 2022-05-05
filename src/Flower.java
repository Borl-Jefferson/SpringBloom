import java.awt.Color;
import java.util.Random;

import processing.core.PApplet;

public abstract class Flower {
    public static Color[] RANDOM_COLOR = null;
    
    float x, y, petalLength, bloomAmount;
    int numPetals;
    int petalColor;
    Color[] colors;
    PApplet processing;
    Random rand = new Random();
    int spinDirection = rand.nextBoolean() ? 1 : -1;
    
    public Flower(PApplet processing, Color[] colors) {
        this.processing = processing;
        this.colors = colors;
        this.bloomAmount = 0;
    }
    
    protected int getColor() {
        if( colors == RANDOM_COLOR ) {
            return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)).getRGB();
        }
        
        return colors[rand.nextInt(colors.length)].getRGB();
    }
    
    void checkBloom() {
        float distToMouse = PApplet.dist(processing.mouseX, processing.mouseY, x, y);
        
        boolean bloomFlower = (distToMouse < 150) ? true : false;
        
        if( bloomFlower ) {
            // Bloom (grow)
            bloomAmount = PApplet.lerp(bloomAmount, 1.0f, 0.1f);
        } else {
            // Un-bloom (shrink)
            bloomAmount = PApplet.lerp(bloomAmount, 0.0f, 0.06f);
        }
    }
    
    void spinFlower(int spinSpeed) {
        processing.rotate(spinDirection * bloomAmount * spinSpeed);
    }
}
