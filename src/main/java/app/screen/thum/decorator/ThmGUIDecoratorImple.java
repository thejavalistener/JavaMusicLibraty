package app.screen.thum.decorator;

import java.awt.Color;

public class ThmGUIDecoratorImple implements ThmGUIDacorator
{
	@Override
	public int getDividerLocation()
	{
		return 200;
	}
	
	@Override
	public Color getDividerColor()
	{
		return new Color(51,51,51);
	}

	
	@Override
	public ThmControlsDecorator getControlsDecorator()
	{
		return new ThmControlsDecoratorImple();
	}

	@Override
	public ThmPageDecorator getPageDecorator()
	{
		return new ThmPageDecoratorImple();
	}

	@Override
	public Color getBackground()
	{
		return new Color(18,18,18);
	}
}
