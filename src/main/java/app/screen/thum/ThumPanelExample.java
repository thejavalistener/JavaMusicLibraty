package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import spotify.Album;
import spotify.Artist;
import thejavalistener.fwk.util.MyColor;
import thejavalistener.fwk.util.MyNumber;
import thejavalistener.fwk.util.string.MyString;

public class ThumPanelExample
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Thumbnail Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,450);

//		MyPanel.DEBUG_MODE = true;
		
		ThumbPanel tp = new ThumbPanel(4);
		tp.setBackground(new Color(18,18,18));
		
		frame.add(tp.c(),BorderLayout.CENTER);
		
//		JButton btn=new JButton("Load");
//		btn.addActionListener(l -> {
//			Thumbnail t = new Thumbnail(320);
//			t.setBackground(new Color(31,31,31));
//			t.setAlbum(Thumbnail.createDemoAlbum());
//			tp.add(t);
//			tp.setTitle(MyString.generateRandom('A','Z',10,15));
//		});
//
//		frame.add(btn,BorderLayout.SOUTH);

		frame.setSize(650,500);

		// Mostrar la ventana
		frame.setVisible(true);
	}	
}
