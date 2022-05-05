import java.awt.Color;

import processing.core.PApplet;

/*
 * Create a Spring Bloom of flowers!
 * 
 * The field already contains an array of Daisy flowers so your job is to:
 * 1. Use the Orchid class to create an array of Orchids and draw them.
 *    in your field. You can use the Daisy example below to help you.
 * 
 * 2. Go into the Lilac class and complete the code to create a Lilac flower.
 * 
 * 3. Create an array of Lilacs (just like you did for Orchids) and draw them
 *    on your field!
 * 
 * 4. Create your own Flower class and make your own unique field of flowers!
 */

public class FlowerBloom extends PApplet {
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static final int NUM_FLOWERS = 20;
    
    Grass grass;
    Color[] colors = { new Color(255), new Color(0xff, 0x81, 0x52), new Color(0xf0, 0x42, 0x78),
                       new Color(0xf0, 0x42, 0x78), new Color(0xcc, 0x27, 0xd5), new Color(0xf7, 0xd3, 0x3a) };
    
    /*
     * Declare your flower arrays here!
     */
    Daisy[] daisys;
    
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        grass = new Grass(this);
        
        /*
         * 1. Initialize your flower arrays here!
         */
        daisys = new Daisy[NUM_FLOWERS];
        
        for (int i = 0; i < NUM_FLOWERS; i++) {
            daisys[i]  = new Daisy(this, Flower.RANDOM_COLOR);
        }
        
        grass.draw();
        
        loadPixels();
    }
    
    @Override
    public void draw() {
        updatePixels();
        
        /*
         * Iterate through your flower arrays here and draw each one of your flowers here!
         */
        for( Daisy daisy : daisys ) {
            daisy.draw();
        }
        
    }

    static public void main(String[] args) {
        PApplet.main(FlowerBloom.class.getName());
    }
}