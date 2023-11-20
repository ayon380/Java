import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.Color;

class MyJFrame extends JFrame {
	public static void main(String args[]) {
		MyJFrame jf = new MyJFrame();
		java.awt.Container c = jf.getContentPane();
		c.setBackground(Color.RED);
		JLabel l=new JLabel("Java");
		l.setFont(new Font("Helvertica", Font.BOLD,34));
		c.add(l);
		JButton b1=new JButton("Java");
		JButton b2=new JButton( "c++");
		Border bd=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.red,Color.green); 
		b1.setBorder(bd);
		b2.setBorder(bd);
		c.add(b1);
		c.add(b2);

		jf.setTitle("My  First Frame in Swing");
		jf.setSize(200, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}