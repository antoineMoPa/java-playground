package acme.marketing.main;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.lang.Math;

public class Fract extends JPanel implements ActionListener{
	private double initial_real = 0.0;
	private double initial_ima = 0.0;
	
	protected void paintComponent(Graphics g){
		int w = this.getWidth();
		int h = this.getHeight();
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				double real = (float)i/(float)w*4.0 - 2.0;
				double ima = (float)j/(float)h*4.0 - 2.0;
				
				real = initial_real;
				ima = initial_ima;
				
				int k;
				int iterations = 30;
				
				for(k = 0; k < iterations; k++){
				    // To the 2
					double oldreal = real;
					double oldima = ima;
				    
				    real = Math.pow(real, 2.0) - Math.pow(ima, 2.0);
				    ima = 2.0 * oldreal * oldima;
				    
				    real += (float)i/(float)w*4.0 - 2.5;
				    ima  += (float)j/(float)h*4.0 - 2.0;
				    
				    if(Math.sqrt(Math.pow(real, 2.0) + Math.pow(ima, 2.0)) > 2.0){
				    	break;
				    }
				}
				
				float ratio = (float)k/(float)iterations;
				
				float red = (float) (Math.floor(ratio*(float)20.0)/10.0);
				float green = (float) (Math.floor(ratio*(float)30.0)/28.0);
				float blue = (float) (Math.floor(ratio*(float)10.0)/4.0);
				
				red = (float) Math.min(red, 1.0);
				green = (float) Math.min(green, 1.0);
				blue = (float) Math.min(blue, 1.0);
				
				g.setColor(
					new Color(
						(float)red, (float)green, (float)blue
					)
				);
				
				g.fillRect(i, j, 1, 1);
			}
		}
		
		g.drawString("2 KOOL 4 SKOOL", (int)(getWidth()/2.0), (int)(getHeight()/2.0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		initial_real += 0.05;
		initial_ima += 0.05;
	}
}
