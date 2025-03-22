package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import thejavalistener.fwk.util.string.MyString;

public class ThumPanelExample
{
	public static void main(String[] args)
	{
		ThmSection section = new ThmSection();
		
		
		
		
		JFrame frame=new JFrame("Thumbnail Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,450);
		
		// creo una seccion
		ThmSection seccion = new ThmSection();
		seccion.setDecorator(new ThmSectionDecoratorImple());
		
		frame.add(seccion.c(),BorderLayout.CENTER);
		
		JButton btn=new JButton("Load");
		btn.addActionListener(l -> {
			Thumbnail t = new Thumbnail(320);
			t.setAlbum(Thumbnail.createDemoAlbum());
			seccion.add(t);
			seccion.setTitle(MyString.generateRandom('A','Z',10,15));
		});

		frame.add(btn,BorderLayout.SOUTH);

		frame.setSize(650,500);

		// Mostrar la ventana
		frame.setVisible(true);
	}	
}
