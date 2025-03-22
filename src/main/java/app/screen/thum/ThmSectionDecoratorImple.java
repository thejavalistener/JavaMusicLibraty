package app.screen.thum;

import java.awt.Color;

import thejavalistener.fwk.awt.link.MyLink;

public class ThmSectionDecoratorImple implements ThmSectionDecorator
{
	@Override
	public Color getSectionBackground()
	{
		return new Color(18,18,18);
	}

	@Override
	public int[] getVHGap()
	{
		return new int[]{20,20};
	}

	@Override
	public void decoreSectionTitle(MyLink lnkTitle)
	{
		lnkTitle.getStyle().background = Color.ORANGE;
	}

	@Override
	public ThmDecorator getThmbnailDecorator()
	{
		return new ThmDecoratorImple();
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}
}
