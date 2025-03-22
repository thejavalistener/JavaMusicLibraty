package app.screen.thum;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import thejavalistener.fwk.awt.testui.MyTestUI;

public class ThumPanelExample
{
	public static void main(String[] args)
	{
		ThmSection section = new ThmSection();
		section.setDecorator(new ThmSectionDecoratorImple());
		section.setTitle("The Beatles");
		
		
		MyTestUI.test(section.c()).addButton("Add",l->{
			Thumbnail t = new Thumbnail(350);
			t.setAlbum(Thumbnail.createDemoAlbum());
			section.add(t);
		}).maximize().run();
		
		
//		
//		JFrame frame=new JFrame("Thumbnail Example");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(650,450);
//		
//		// creo una seccion
//		ThmSection seccion = new ThmSection();
//		seccion.setDecorator(new ThmSectionDecoratorImple());
//		seccion.setTitle("The Beatles");
//		
//		frame.add(seccion.c(),BorderLayout.CENTER);
//		
//		JButton btn=new JButton("Load");
//		btn.addActionListener(l -> {
//			Thumbnail t = new Thumbnail(320);
//			t.setAlbum(Thumbnail.createDemoAlbum());
//			seccion.add(t);
//		});
//
//		frame.add(btn,BorderLayout.SOUTH);
//
//		frame.setSize(650,500);
//
//		// Mostrar la ventana
//		frame.setVisible(true);
	}	
}
