package quadtree;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Particle {

	int x, y, size, bound;
	int speedX, speedY;
	Random random = new Random();
	
	public Particle(int _bound) {

		this.bound = _bound;
		this.size = 8;
		
		this.x = random.nextInt(bound - this.size);
		this.y = random.nextInt(bound - this.size);
		
		this.speedX = (random.nextInt(2)+1) * (random.nextBoolean()?-1:1);
		this.speedY = (random.nextInt(2)+1) * (random.nextBoolean()?-1:1);
		
	}
	
	public void Move() {
		this.x += speedX;
		this.y += speedY;
		
		if(this.x + this.size >= bound || this.x <= 0) 
			this.speedX *= -1;
		
		if(this.y + this.size >= bound || this.y <= 0) 
			this.speedY *= -1;
	}
	
	public void Draw(Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.fillOval(this.x, this.y, this.size, this.size);
	}
	
}
