package app.screen.thum.decorator;

import java.awt.Color;

import thejavalistener.fwk.awt.link.MyLink;

public interface ThmPageDecorator
{
	public Color getPageBackground();
	public int getSectionGap();
	public int getScrollbarSpeed();
	public ThmSectionDecorator getSectionDecorator();
}
