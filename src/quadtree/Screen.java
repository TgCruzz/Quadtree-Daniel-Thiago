package quadtree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Screen extends JPanel {

	ArrayList<Particle> particles;
	
	public Screen(ArrayList<Particle> _particles) {
		setBorder(BorderFactory.createLineBorder(Color.black));		
		
		particles = _particles;
	}	
	
	public Dimension getPreferredSize() {
        return new Dimension(1000,1000);
    }
	
	public void paintComponent(Graphics graphics) {
		super.paintComponents(graphics);
		
		for(Particle p : particles){
			graphics.setColor(Color.black);
			graphics.fillOval(p.x, p.y, p.size, p.size);
		}
		
		
	}
	
}
