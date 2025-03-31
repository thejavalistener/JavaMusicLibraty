package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;

import app.screen.thum.decorator.ThmPageDecorator;
import thejavalistener.fwk.awt.MyScrollPane;
import thejavalistener.fwk.awt.panel.GridLayout2;
import thejavalistener.fwk.awt.panel.MyBorderLayout;
import thejavalistener.fwk.awt.panel.MyPanel;

public class ThmPage
{
	private JPanel contentPane;
	private JPanel ccontentPane;
	
	private MyScrollPane2 scrollPane;
	
	private ThmPageDecorator decorator;
	
	public ThmPage()
	{
		contentPane = new MyBorderLayout();
		contentPane.setBorder(null);
		ccontentPane = new MyPanel(0,0,0,0);
		ccontentPane.setBorder(null);
		ccontentPane.setLayout(new GridLayout2(0,1,0,0));
		
		contentPane.add(scrollPane=new MyScrollPane2(ccontentPane),BorderLayout.CENTER);
		scrollPane.setBorder(null);
	}
	
	public ThmSection createSection(String title)
	{
		ThmSection section = new ThmSection();
		section.setTitle(title);
		addSection(section);
		return section;
	}
	
	public void addSection(ThmSection section)
	{
		section.setDecorator(decorator.getSectionDecorator());

		int sectionGap = decorator.getSectionGap();
		MyBorderLayout p = new MyBorderLayout(0,0,sectionGap,0);
		p.setBackground(decorator.getPageBackground());
		
		p.add(section.c(),BorderLayout.CENTER);
		ccontentPane.add(p);
		
		scrollPane.revalidate();
		ccontentPane.revalidate();
	}
	
	public void removeSections()
	{
		ccontentPane.removeAll();
		ccontentPane.revalidate();
		ccontentPane.repaint();
	}
		
	public Component c()
	{
		return contentPane;
	}
	
	public void setDecorator(ThmPageDecorator decorator)
	{
		contentPane.setBackground(decorator.getPageBackground());
		ccontentPane.setBackground(decorator.getPageBackground());
		
		scrollPane.setBackground(decorator.getPageBackground());
		scrollPane.configureScrollBars(decorator.getScrollbarWidth(),decorator.getScrollbarForeground());
		
		JScrollBar vScrollBar = scrollPane.getVerticalScrollBar();

		// Configurar la velocidad
		vScrollBar.setUnitIncrement(decorator.getScrollbarSpeed());    // Incremento por unidad en el scroll vertical
		vScrollBar.setBlockIncrement(decorator.getScrollbarSpeed());  // Incremento por bloque en el scroll vertical
		this.decorator = decorator;
	}
}
