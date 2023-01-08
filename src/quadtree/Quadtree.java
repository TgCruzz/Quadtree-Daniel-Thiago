package quadtree;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Quadtree {

	int max;
	Zone zone;
	
	Quadtree NW;
	Quadtree NE;
	Quadtree SW;
	Quadtree SE;
	boolean isSplit;
		
	ArrayList<Particle> particles;
	ArrayList<Particle> assignedParticles;
	
	public Quadtree(Zone _zone, ArrayList<Particle> _particles) {
		this.max = 1;
		this.zone = _zone;
		this.particles = _particles;
		this.assignedParticles = new ArrayList();
		this.isSplit = false;
		
		this.Assign();
		
		if (this.assignedParticles.size() > max)						
			this.Split();
	}
	
	public void Assign (){	
		
		for (Particle p : this.particles) {
			if (p.x + p.size <= this.zone.x + this.zone.size && p.x >= this.zone.x &&
				p.y + p.size <= this.zone.y + this.zone.size && p.y >= this.zone.y) {
				assignedParticles.add(p);
			}				
		}		
	}
	
	public void Split () {
		this.NW = new Quadtree(new Zone(this.zone.x, this.zone.y, this.zone.size/2),
				this.assignedParticles);
		this.NE = new Quadtree(new Zone(this.zone.x + this.zone.size/2, this.zone.y, this.zone.size/2),
				this.assignedParticles);
		this.SW = new Quadtree(new Zone(this.zone.x, this.zone.y + this.zone.size/2, this.zone.size/2),
				this.assignedParticles);
		this.SE = new Quadtree(new Zone(this.zone.x + this.zone.size/2, this.zone.y + this.zone.size/2, this.zone.size/2),
				this.assignedParticles);
		this.isSplit = true;
	}
	
	public void Draw(Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.drawRect(this.zone.x, this.zone.y, this.zone.size, this.zone.size);
		
		if(this.isSplit) {
			this.NW.Draw(graphics);
			this.NE.Draw(graphics);
			this.SW.Draw(graphics);
			this.SE.Draw(graphics);
		}
	}
	
}
