import java.awt.Color;

import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Lilac extends Flower {

	public Lilac(PApplet processing, Color[] colors) {
		super(processing, colors);

		this.x = rand.nextInt(processing.width);
		this.y = rand.nextInt(processing.height);

		/*
		 * 1. Set the number of petals for your flower using this.numPetals
		 */
		this.numPetals = 8;
	/*
		 * 2. Set the petal color for your flower using this.petalColor
		 */
		this.petalColor = getColor();
	}

	public void draw() {
		processing.push();
		processing.translate(x, y);

		checkBloom();

		/*
		 * 3. These variables change the flower size when you mouse is nearby You can
		 * change these values if you like!
		 */
		float flowerCenterRadius = 120 * bloomAmount;
		float petalLength = flowerCenterRadius;

		/*
		 * 4. Call SpinFlower() and pass in the spin speed (1 = no spin, 2 = more spin,
		 * etc.)
		 * 
		 */
		spinFlower(99999999);
		/*
		 * Draw flower -- You don't need to change this!
		 */
		drawPetals(petalLength);
		drawFlowerCenter(flowerCenterRadius);

		processing.pop();
	}

	void drawPetals(float petalLength) {
		for (int i = 0; i < this.numPetals; i += 1) {
			processing.rotate(PApplet.radians(i * 45));
			drawPetal(petalLength);
		}
	}

	void drawPetal(float petalLength) {
if(processing.key == 32) {
	this.numPetals = 200;
}
if(processing.key == (int) 'd') {
	this.numPetals = 8;
}
	
		/*
		 * 5. Create a for loop that iterates from 0 to the petalLength
		 */
		for (int i = 0; i < petalLength; i++) {

			/*
			 * 6. Call processing.noStroke()
			 */
			processing.noStroke();
			if (i > petalLength * 0.1) {
				processing.fill(petalColor);

			} else {
				processing.fill(255);
			}

			processing.ellipse(petalLength - i, 0, 50, petalLength - i);

		}

	}

	void drawFlowerCenter(float flowerCenterRadius) {
		processing.noStroke();
		processing.fill(119, 27, 27);
		processing.ellipse(0, 0, flowerCenterRadius, flowerCenterRadius);
	}
}
