package app.screen.thum.decorator;

import java.awt.Color;

import thejavalistener.fwk.awt.link.MyLink;

public interface ThmSectionDecorator
{
	public Color getSectionBackground();
	public int[] getVHGap();
	public void decoreSectionTitle(MyLink lnkTitle);
	public ThmDecorator getThmbnailDecorator();
	public int getColumnCount();
}
