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

	private MyLink lnkFilterTitle;
	private MyLink lnkLabelTitle;
	
	private ThmControlsDecorator decorator;
	private ThmControlsListener listener;
	
	private ThmControls outer = this;
	
	public ThmControls()
	{
		pFilters = new JPanel(new MatrixLayout(1,0,0));
		pFilters.setBackground(MyColor.random());

		pLabels = new JPanel(new MatrixLayout(1,0,0));

		splitPane = new MySplitPane(MySplitPane.HORIZONTAL,pFilters,pLabels);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(100);
		
		contentPane = new  MyBorderLayout();
		contentPane.add(splitPane.c(),BorderLayout.CENTER);

		lnkGrpFilters = new MyLinkGroup();
		lnkGrpFilters.setActionListener(new EscuchaFilter());
		lnkGrpLabels = new MyLinkGroup();	
		lnkGrpLabels.setActionListener(new EscuchaLabel());
		
		lnkFilterTitle = new MyLink("");
		lnkLabelTitle = new MyLink("");
				
		pFilters.add(lnkFilterTitle.c());
		pLabels.add(lnkLabelTitle.c());
		
	}
	
	public void setDecorator(ThmControlsDecorator decorator)
	{
		this.decorator = decorator;
		splitPane.setDividerLocation(decorator.getDividerLocation());
		splitPane.setDividerColor(decorator.getDividerColor());
		pFilters.setBackground(decorator.getFiltersBackground());
		pLabels.setBackground(decorator.getLabelsBackground());	

		decorator.decoreFilterTitle(lnkFilterTitle);
		lnkFilterTitle.setText(decorator.getDefaultFilterTitle());

		lnkLabelTitle.setText(decorator.getDefaultLabelTitle());
		decorator.decoreLabelTitle(lnkLabelTitle);
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
		int n = pLabels.getComponentCount()-1;
		while(pLabels.getComponentCount()>1 )
		{
			Component cmp = pLabels.getComponent(n);
			if( !cmp.equals(lnkLabelTitle.c()) )
			{
				pLabels.remove(cmp);
				n--;
			}
		}

		pLabels.revalidate();
		pLabels.repaint();
		
		lnkLabelTitle.setText(decorator.getDefaultLabelTitle());
	}	
	
	public void setSelectedFilter(String filter)
	{
		throw new RuntimeException("No implementado todavía");
	}
	
	public void setSelectedLabel(String label)
	{
		throw new RuntimeException("No implementado todavía");
	}

	public void setLabelTitle(String title)
	{
		lnkLabelTitle.setText(title);
	}
	
	public void setFilterTitle(String title)
	{
		lnkFilterTitle.setText(title);
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
				listener.filterSelected(outer,filter.toUpperCase());
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
			listener.labelSelected(outer,filter,label);
		}
	}
}
