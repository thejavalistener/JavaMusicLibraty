package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import app.screen.thum.decorator.ThmGUIDacorator;
import thejavalistener.fwk.awt.panel.MyBorderLayout;
import thejavalistener.fwk.awt.panel.MyPanel;
import thejavalistener.fwk.awt.splitpane.MySplitPane;

public class ThmGUI
{
	private JPanel contentPane;
	private JPanel pNorth;
	private MySplitPane splitPane;
	
	private ThmGUIDacorator decorator;
	private ThmControls controls;
	private ThmPage page;
	
	public ThmGUI()
	{
		contentPane = new MyBorderLayout();
		
		pNorth = new MyPanel(20,0,20,0);
		contentPane.add(pNorth,BorderLayout.NORTH);

		controls = new ThmControls();
		page = new ThmPage();

		splitPane = new MySplitPane(MySplitPane.VERTICAL,controls.c(),page.c());
		contentPane.add(splitPane.c(),BorderLayout.CENTER);
	}
	
	public void setDecorator(ThmGUIDacorator decorator)
	{
		this.decorator = decorator;
		
		pNorth.setBackground(decorator.getBackground());
		controls.setDecorator(decorator.getControlsDecorator());
		page.setDecorator(decorator.getPageDecorator());
		
		splitPane.setDividerColor(decorator.getDividerColor());
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(decorator.getDividerLocation());
	}
	
	public Component c()
	{
		return contentPane;
	}

	public ThmControls getControls()
	{
		return controls;
	}

	public ThmPage getPage()
	{
		return page;
	}
}

