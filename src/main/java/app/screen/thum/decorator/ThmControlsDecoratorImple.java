package app.screen.thum.decorator;

import java.awt.Color;

import thejavalistener.fwk.awt.link.MyLink;

public class ThmControlsDecoratorImple implements ThmControlsDecorator
{

	@Override
	public Color getFiltersBackground()
	{
		return Color.YELLOW;//new Color(18,18,18);
	}

	@Override
	public Color getLabelsBackground()
	{
		return Color.ORANGE;//new Color(18,18,18);
	}

	@Override
	public int getDividerLocation()
	{
		return 100;
	}
	
	@Override
	public Color getDividerColor()
	{
		return new Color(51,51,51);
	}
	
	@Override
	public void decoreFilterTitle(MyLink lnk)
	{
	}

	@Override
	public void decoreLabelTitle(MyLink lnk)
	{
	}
	

	@Override
	public void decoreFilter(MyLink lnk)
	{
	}

	@Override
	public void decoreLabel(MyLink lnk)
	{
	}
}
