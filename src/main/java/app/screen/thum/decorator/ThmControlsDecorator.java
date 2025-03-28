package app.screen.thum.decorator;

import java.awt.Color;

import thejavalistener.fwk.awt.link.MyLink;

public interface ThmControlsDecorator
{
	public Color getFiltersBackground();
	public Color getLabelsBackground();
	public int getDividerLocation();
	public Color getDividerColor();
	public void decoreFilter(MyLink lnk);
	public void decoreLabel(MyLink lnk);
}
