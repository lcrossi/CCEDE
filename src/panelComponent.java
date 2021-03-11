import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class panelComponent extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	
	void painel(){
		contentPane = new JPanel();
		contentPane.setLayout(null);  
	    //contentPane.setBackground(Color.WHITE);  
	    contentPane.add(this);  
	    this.setBounds(-200, 0, 1100, 1100);
	    contentPane.setForeground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {    
        try {     
         super.paintComponent(g);
         Image imagem = new ImageIcon("background.png").getImage(); 
         g.drawImage(imagem, 0, 0, this);
            }    
        catch(Exception e) {  
           System.out.println("Imagem não localizada");  
        }  
    }
	
}