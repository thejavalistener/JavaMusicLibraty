package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import thejavalistener.fwk.awt.MatrixLayout;
import thejavalistener.fwk.awt.MyScrollPane;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.panel.MyBorderLayout;

public class ThumbPanel
{
	private JPanel contentPane;
	private MyLink lnkTitle;
	private JPanel matrix;
	private MyScrollPane scrollPane;
	private Color thumbnailBackground = Color.RED;
	
	
	public ThumbPanel(int n)
	{
		contentPane = new MyBorderLayout();
		
		lnkTitle = new MyLink("");
		contentPane.add(lnkTitle.c(),BorderLayout.NORTH);
		
		matrix = new JPanel(new MatrixLayout(n,20,20));
		contentPane.add(scrollPane = new MyScrollPane(matrix),BorderLayout.CENTER);
	}
	
	public void setBackground(Color c)
	{
		contentPane.setBackground(c);
		matrix.setBackground(c);
	}
		
	public void add(Thumbnail t)
	{
//		t.setBackground(thumbnailBackground);
		matrix.add(t.c());
	}
	
	public void setTitle(String t)
	{
		lnkTitle.setText(t);
	}
	
	public Component c()
	{
		return contentPane;
	}

	public void setThumbnailBackgroundX(Color color)
	{
		thumbnailBackground = color;
	}
}
