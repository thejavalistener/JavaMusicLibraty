package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import thejavalistener.fwk.awt.MyScrollPane;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.panel.MyBorderLayout;

public class ThumbPanel
{
	private JPanel contentPane;
	private MyLink lnkTitle;
	private JPanel panel;
	private MyScrollPane scrollPane;
	
	public ThumbPanel(int n)
	{
		contentPane = new MyBorderLayout();
		
		lnkTitle = new MyLink("");
		contentPane.add(lnkTitle.c(),BorderLayout.NORTH);
		
		panel = new JPanel(new MatrixLayout(n,20,20));
		contentPane.add(scrollPane = new MyScrollPane(panel),BorderLayout.CENTER);
	}
	
	public void add(Thumbnail t)
	{
		panel.add(t);
	}
	
	public void setTitle(String t)
	{
		lnkTitle.setText(t);
	}
	
	public Component c()
	{
		return contentPane;
	}
}
