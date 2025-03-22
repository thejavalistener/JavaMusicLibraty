package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import thejavalistener.fwk.awt.MyScrollPane;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.panel.MatrixLayout;
import thejavalistener.fwk.awt.panel.MyBorderLayout;

public class ThmSection
{
	private JPanel contentPane;
	private MyLink lnkTitle;
	private JPanel matrix;
	private ThmSectionDecorator decorator;
	
	public ThmSection()
	{
		contentPane = new MyBorderLayout();
		
		lnkTitle = new MyLink("");
		contentPane.add(lnkTitle.c(),BorderLayout.NORTH);
		
		matrix = new JPanel();
		contentPane.add(new MyScrollPane(matrix),BorderLayout.CENTER);
	}
	
	private void _setBackground(Color c)
	{
		contentPane.setBackground(c);
		matrix.setBackground(c);
	}
		
	public void add(Thumbnail t)
	{
		t.setDecorator(decorator.getThmbnailDecorator());
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

	public void setDecorator(ThmSectionDecorator decorator)
	{
		this.decorator = decorator;
		int nCols = decorator.getColumnCount();
		int vGap = decorator.getVHGap()[0];
		int hGap = decorator.getVHGap()[1];		
		matrix.setLayout(new MatrixLayout(nCols,vGap,hGap));
		_setBackground(decorator.getSectionBackground());
	}
}
