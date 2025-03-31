package app.screen.thum.decorator;

import java.awt.Color;

public interface ThmGUIDacorator
{
	public ThmControlsDecorator getControlsDecorator();
	public ThmPageDecorator getPageDecorator();
	public int getDividerLocation();
	public Color getDividerColor();
	public Color getBackground();
}
