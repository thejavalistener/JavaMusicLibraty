package app.screen.thum;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

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
	public void decoreSectionTitle(MyLink lnk)
	{
		lnk.getStyle().linkForegroundUnselected = new Color(249,249,249);
		lnk.getStyle().setLinkFont(new Font("Arial Black",Font.PLAIN,72));
		Insets i = lnk.getStyle().linkBackgroundInsets;
		i.top = 7;
		lnk.c().validate();
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
