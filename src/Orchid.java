import java.awt.Color;

import processing.core.PApplet;

public class Orchid extends Flower {

    public Orchid(PApplet processing, Color[] colors) {
        super(processing, colors);

        this.x = rand.nextInt(processing.width);
        this.y = rand.nextInt(processing.height);
        this.numPetals = rand.nextInt(4) + 6;
        this.petalColor = getColor();
        this.bloomAmount = 0;
    }

    public Orchid(PApplet processing, float x, float y, float r, int petals, Color[] colors) {
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
        float petalLength = flowerCenterRadius * 2;
        
        /*
         * Spin flower
         */
        spinFlower(2);
        
        /*
         * Draw flower
         */
        drawPetals(petalLength);
        drawFlowerCenter(flowerCenterRadius);
        
        processing.pop();
    }
    
    void drawFlowerCenter(float flowerCenterRadius) {
        processing.noStroke();
        processing.fill(119, 27, 27);
        processing.ellipse(0, 0, flowerCenterRadius, flowerCenterRadius);
    }
    
    void drawPetals(float petalLength) {
        for (int i = 0; i < numPetals; i++) {
            processing.rotate(PApplet.radians(i * 30));
            drawPetal(petalLength);
        }
    }

    void drawPetal(float petalLength) {
        processing.stroke(0, 0, 0, 80);
        
        processing.fill(petalColor);

        /*
         * Draw both halves, positive and negative
         */
        for (int i = -1; i <= 1; i += 2) {
            processing.beginShape();
            for (float angleDeg = 0; angleDeg < 360; angleDeg += 4) {
                float currentRadius = petalLength / PApplet.pow(2, angleDeg / 60);
                float currentX = currentRadius * PApplet.cos(PApplet.radians(angleDeg));
                float currentY = currentRadius * PApplet.sin(PApplet.radians(angleDeg));
                processing.vertex(currentX, i * currentY);
            }
            processing.endShape();
        }
    }
}
