package app.screen.thum.decorator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import thejavalistener.fwk.awt.link.MyLink;

public class ThmControlsDecoratorImple implements ThmControlsDecorator
{
	private Color divider = new Color(51,51,51);
	private Color background = new Color(18,18,18);
	private Color unhighlight = new Color(173,173,173);
	private Color highlight = new Color(249,249,249);
	private Color shadow = new Color(49,49,49);
	private Font font = new Font("Calibri",Font.PLAIN,14);
	
	@Override
	public Color getFiltersBackground()
	{
		return background;
	}

	@Override
	public Color getLabelsBackground()
	{
		return background;
	}

	@Override
	public int getDividerLocation()
	{
		return 150;
	}
	
	@Override
	public Color getDividerColor()
	{
		return divider;
	}
	
	@Override
	public void decoreFilterTitle(MyLink lnk)
	{
		decoreLabelTitle(lnk);
	}

	@Override
	public void decoreLabelTitle(MyLink lnk)
	{
		// unselected
		
		// foreground
		lnk.getStyle().linkForegroundUnselected = unhighlight;

		// background
		lnk.getStyle().linkBackgroundUnselected = background;
		
		// rollover foreground
		lnk.getStyle().linkForegroundRolloverUnselected = unhighlight;

		// rollover background
		lnk.getStyle().linkBackgroundRolloverUnselected = background;
		
		
		
		
		lnk.c().revalidate();
	}	

	@Override
	public void decoreFilter(MyLink lnk)
	{
		decoreLabel(lnk);
	}
	
	@Override
	public void decoreLabel(MyLink lnk)
	{
		
		// unselected
		
			// foreground
			lnk.getStyle().linkForegroundUnselected = unhighlight;

			// background
			lnk.getStyle().linkBackgroundUnselected = background;
			
			// rollover foreground
			lnk.getStyle().linkForegroundRolloverUnselected = highlight;
	
			// rollover background
			lnk.getStyle().linkBackgroundRolloverUnselected = shadow;

		// selected
			
			// foreground
			lnk.getStyle().linkForegroundSelected = highlight;

			// background
			lnk.getStyle().linkBackgroundSelected = background;
			
			// rollover foreground
			lnk.getStyle().linkForegroundRolloverSelected = highlight;
	
			// rollover background
			lnk.getStyle().linkBackgroundRolloverSelected = background;

		
		lnk.getStyle().setLinkFont(font);

	}

	@Override
	public String getDefaultFilterTitle()
	{
		return "FILTERS";
	}

	@Override
	public String getDefaultLabelTitle()
	{
		return "LABELS";
	}
}
