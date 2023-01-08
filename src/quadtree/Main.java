package quadtree;

import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {	
	
	ArrayList<Particle> particles;
	int totalParticles, screenSize;
	Quadtree quad;
	
	public Main() {

		screenSize = 1000;
		totalParticles = 50;
		
		particles = new ArrayList();
						
		
		for(int i = 0; i < totalParticles; i++) {
			particles.add(new Particle(screenSize));
		}
		
		quad = new Quadtree(new Zone( 0, 0, screenSize), particles);
		
		Screen screen = new Screen(particles, quad);		
		JFrame frame = new JFrame("Tela");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(screen);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
		while(true) {	
			for(Particle p : particles)
			p.Move();

			quad.Update();
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}			
	
	

}
