import java.awt.Color;

import processing.core.PApplet;

public class Daisy extends Flower {
    
    public Daisy(PApplet processing, Color[] colors) {
        super(processing, colors);
        
        this.x = rand.nextInt(processing.width);
        this.y = rand.nextInt(processing.height);
        this.numPetals = rand.nextInt(10) + 10;
        this.petalLength = rand.nextInt(100) + 100;
        this.petalColor = getColor();
        this.bloomAmount = 0;
    }

    public Daisy(PApplet processing, float x, float y, float r, int petals, Color[] colors) {
        super(processing, colors);
        
        this.x = x;
        this.y = y;
        this.petalLength = r;
        this.numPetals = petals;
        this.colors = colors;
        this.petalColor = getColor();
    }
    
    void draw() {
        processing.push();
        processing.translate(x, y);
        
        checkBloom();
        
        float flowerCenterRadius = 60 * bloomAmount;
        float petalOffsetX = flowerCenterRadius / 6;
        float petalOffsetY = flowerCenterRadius / 6;
        
        /*
         * Spin flower
         */
        processing.ellipseMode(PApplet.CORNER);
        spinFlower(9999999);
        
        /*
         * Petals
         */
        for (int i = 0; i <= this.numPetals; i++) {
            processing.rotate((2 * PApplet.PI) / this.numPetals);
            
            processing.stroke(0, 200);
            processing.fill(petalColor);
            processing.ellipse(petalOffsetX, petalOffsetY, petalLength * bloomAmount, (petalLength / 6) * bloomAmount);
            
            processing.stroke(0, 90);
            processing.line(0, 0, petalLength * bloomAmount, (petalLength / 6) * bloomAmount);
        }
        
        /*
         * Flower Center
         */
        processing.ellipseMode(PApplet.CENTER);
        processing.noStroke();
        processing.fill(119, 27, 27);
        processing.ellipse(0, 0, flowerCenterRadius, flowerCenterRadius);

        processing.pop();
    }
}
