import java.util.Random;

import processing.core.PApplet;

public class Grass {
    static final int NUM_GRASS_BLADES_TO_DRAW = 10000;

    PApplet processing;
    Random rand = new Random();

    public Grass(PApplet processing) {
        this.processing = processing;
    }

    public void draw() {
        processing.fill(0, 255, 0, 127);
        processing.rect(0, 0, processing.width, processing.height);
        
        for (int i = 0; i < NUM_GRASS_BLADES_TO_DRAW; i++) {
            float x = rand.nextInt(processing.width);
            float y = rand.nextInt(processing.height);
            processing.strokeWeight(rand.nextInt(3) + 1);
            processing.stroke(0, rand.nextInt(200), 0);
            processing.line(x, y, x + rand.nextInt(50), y + rand.nextInt(50));
        }
    }
}
