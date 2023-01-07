package quadtree;

import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Particle> particles = new ArrayList();
		int totalParticles = 500;
		
		for(int i = 0; i < totalParticles; i++) {
			particles.add(new Particle(1000));
		}
		
		Screen screen = new Screen(particles);		
		JFrame frame = new JFrame("Tela");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(screen);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
		while(true) {
			for (Particle p : particles)
				p.Move();
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		
	}			

}
