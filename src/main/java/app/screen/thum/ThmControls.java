package app.screen.thum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import app.screen.thum.decorator.ThmControlsDecorator;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.link.MyLinkGroup;
import thejavalistener.fwk.awt.panel.MatrixLayout;
import thejavalistener.fwk.awt.panel.MyBorderLayout;
import thejavalistener.fwk.awt.splitpane.MySplitPane;
import thejavalistener.fwk.util.MyColor;

public class ThmControls
{
	private MyLinkGroup lnkGrpFilters;
	private MyLinkGroup lnkGrpLabels;

	private MySplitPane splitPane;
	private JPanel contentPane;
	private JPanel pLabels;
	private JPanel pFilters;
	
	private ThmControlsDecorator decorator;
	
	private ThmControlsListener listener;
	
	public ThmControls()
	{
		pFilters = new JPanel(new MatrixLayout(1,0,0));
		pFilters.setBackground(MyColor.random());

		pLabels = new JPanel(new MatrixLayout(1,0,0));
		pLabels.setBackground(MyColor.random());

		splitPane = new MySplitPane(MySplitPane.HORIZONTAL,pFilters,pLabels);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(100);
		
		contentPane = new  MyBorderLayout();
		contentPane.add(splitPane.c(),BorderLayout.CENTER);

		lnkGrpFilters = new MyLinkGroup();
		lnkGrpFilters.setActionListener(new EscuchaFilter());
		lnkGrpLabels = new MyLinkGroup();	
		lnkGrpLabels.setActionListener(new EscuchaLabel());
	}
	
	public void setDecorator(ThmControlsDecorator decorator)
	{
		this.decorator = decorator;
		splitPane.setDividerLocation(decorator.getDividerLocation());
		splitPane.setDividerColor(decorator.getDividerColor());
		pFilters.setBackground(decorator.getFiltersBackground());
		pLabels.setBackground(decorator.getLabelsBackground());
	}
	
	public void addFilter(String filter)
	{
		MyLink lnk = new MyLink(filter);
		
		if( decorator!=null )
		{
			decorator.decoreFilter(lnk);
		}
		
		lnkGrpFilters.addLink(lnk);

		pFilters.add(lnk.c());
		contentPane.validate();
	}
	
	public void addLabel(String label)
	{
		MyLink lnk = new MyLink(label);
		
		if( decorator!=null )
		{
			decorator.decoreLabel(lnk);
		}

		lnkGrpLabels.addLink(lnk);		

		pLabels.add(lnk.c());
		contentPane.validate();
	}
	
	public void removeLabels()
	{
		pLabels.removeAll();
		pLabels.revalidate();
		pLabels.repaint();
	}
	
	public void setListener(ThmControlsListener lst)
	{
		this.listener = lst;
	}
	
	public Component c()
	{
		return contentPane;
	}
	
	class EscuchaFilter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(listener!=null)
			{
				String filter = lnkGrpFilters.getSelected().getText();
				listener.filterSelected(filter);
			}
		}
	}
	class EscuchaLabel implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String filter = lnkGrpFilters.getSelected().getText();
			String label = lnkGrpLabels.getSelected().getText();
			listener.labelSelected(filter,label);
		}
	}
}
