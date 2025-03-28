package app.screen.thum.decorator;

import java.awt.Color;

public class ThmPageDecoratorImple implements ThmPageDecorator
{
	ThmSectionDecorator sectionDecorator = new ThmSectionDecoratorImple();

	@Override
	public Color getPageBackground()
	{
		return new Color(18,18,18);
	}

	@Override
	public int getSectionGap()
	{
		return 35;
	}

	@Override
	public int getScrollbarSpeed()
	{
		return 35;
	}

	@Override
	public ThmSectionDecorator getSectionDecorator()
	{
		return sectionDecorator;
	}

}
