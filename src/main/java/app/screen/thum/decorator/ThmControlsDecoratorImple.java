package app.screen.thum.decorator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import thejavalistener.fwk.awt.link.MyLink;


public class ThmControlsDecoratorImple implements ThmControlsDecorator
{
	private Font font = new Font(ThmColors.fontName,Font.PLAIN,14);
	
	@Override
	public Color getFiltersBackground()
	{
		return ThmColors.background;
	}

	@Override
	public Color getLabelsBackground()
	{
		return ThmColors.background;
	}

	@Override
	public int getDividerLocation()
	{
		return 150;
	}
	
	@Override
	public Color getDividerColor()
	{
		return ThmColors.divider;
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
		lnk.getStyle().linkForegroundUnselected = ThmColors.unhighlight;

		// background
		lnk.getStyle().linkBackgroundUnselected = ThmColors.background;
		
		// rollover foreground
		lnk.getStyle().linkForegroundRolloverUnselected = ThmColors.unhighlight;

		// rollover background
		lnk.getStyle().linkBackgroundRolloverUnselected = ThmColors.background;
		
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
			lnk.getStyle().linkForegroundUnselected = ThmColors.unhighlight;

			// background
			lnk.getStyle().linkBackgroundUnselected = ThmColors.background;
			
			// rollover foreground
			lnk.getStyle().linkForegroundRolloverUnselected = ThmColors.unhighlight;
	
			// rollover background
			lnk.getStyle().linkBackgroundRolloverUnselected = ThmColors.shadow;

		// selected
			
			// foreground
			lnk.getStyle().linkForegroundSelected = ThmColors.highlight;

			// background
			lnk.getStyle().linkBackgroundSelected = ThmColors.background;
			
			// rollover foreground
			lnk.getStyle().linkForegroundRolloverSelected = ThmColors.highlight;
	
			// rollover background
			lnk.getStyle().linkBackgroundRolloverSelected = ThmColors.background;
		
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