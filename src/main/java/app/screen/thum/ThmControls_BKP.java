package app.screen.thum;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.link.MyLinkGroup;
import thejavalistener.fwk.awt.panel.GridLayout2;
import thejavalistener.fwk.awt.panel.MatrixLayout;

public class ThmControls_BKP
{
	private MyLinkGroup lnkGrpFilters;
	private MyLinkGroup lnkGrpLabels;

	private JPanel contentPane;
	private JPanel pFilters;
	private JPanel pLabels;
	
	private Map<String,List<String>> labels;
	
	public ThmControls_BKP()
	{
		contentPane = new JPanel(new GridLayout2(2,1,0,0));
	
		lnkGrpFilters = new MyLinkGroup();
		pFilters = new JPanel(new MatrixLayout(1,0,0));
		
		lnkGrpLabels = new MyLinkGroup();
		pLabels = new JPanel(new MatrixLayout(1,0,0));
	
		contentPane.add(pFilters);
//		contentPane.add(new Separator(0.8));
		contentPane.add(pLabels);
		
		labels = new HashMap<>();
	}
	
	public void addFilter(String filter)
	{
		labels.put(filter,new ArrayList<>());
		
		MyLink lnk = new MyLink(filter);
		lnkGrpFilters.addLink(lnk);

		pFilters.add(lnk.c());
		contentPane.validate();
	}
	
	public void addLabel(String filter,String label)
	{
		labels.get(filter).add(label);
		
		MyLink lnk = new MyLink(label);
		lnkGrpLabels.addLink(lnk);		

		pLabels.add(lnk.c());
		contentPane.validate();
	}
	
	public Component c()
	{
		return contentPane;
	}
}
