package app;

import java.awt.GridLayout;

import javax.swing.JPanel;

import thejavalistener.fwk.awt.link.MyLink;

public class ThmbDetails extends JPanel
{
	private MyLink lnk1;
	private MyLink lnk2;
	private MyLink lnk3;
	
	public ThmbDetails()
	{
		setLayout(new GridLayout(3,1));
		
		lnk1 = new MyLink("",MyLink.LINK);
		add(lnk1.c());

		lnk2 = new MyLink("",MyLink.LINK);
		add(lnk2.c());
		
		lnk1 = new MyLink("",MyLink.LINK);
		add(lnk3.c());
	}
	
	public void setDetails(String line1,String line2,String line3)
	{
		lnk1.setText(line1);
		lnk2.setText(line2);
		lnk3.setText(line3);
	}
}
