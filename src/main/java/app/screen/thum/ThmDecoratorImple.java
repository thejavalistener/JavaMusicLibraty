package app.screen.thum;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import thejavalistener.fwk.awt.link.MyLink;

public class ThmDecoratorImple implements ThmDecorator
{
	@Override
	public Color getThumbnailBackground()
	{
		return new Color(29,29,29);
	}
	
	@Override
	public void decoreTitle(MyLink lnk)
	{
		lnk.getStyle().linkForegroundUnselected = new Color(249,249,249);
		lnk.getStyle().setLinkFont(new Font("Calibri",Font.PLAIN,16));
		Insets i = lnk.getStyle().linkBackgroundInsets;
		i.top = 7;
	}				
	
	@Override
	public void decoreArtist(MyLink lnk)
	{
		lnk.getStyle().linkForegroundUnselected = new Color(173,173,173);
		lnk.getStyle().linkForegroundRolloverUnselected = new Color(249,249,249);
		lnk.getStyle().setLinkFont(new Font("Calibri",Font.PLAIN,14));
		lnk.getStyle().setLinkBackgroundUnselected(getThumbnailBackground());
		lnk.getStyle().setLinkBackgroundRolloverUnselected(getThumbnailBackground());
		Insets i = lnk.getStyle().linkBackgroundInsets;
		i.top = 0;
		i.bottom = 3;
	}
		
	@Override
	public void decoreReleasedYear(MyLink lnk)
	{
		lnk.getStyle().linkForegroundUnselected = new Color(173,173,173);
		lnk.getStyle().linkForegroundRolloverUnselected = new Color(249,249,249);
		lnk.getStyle().setLinkFont(new Font("Calibri",Font.PLAIN,14));
		lnk.getStyle().setLinkBackgroundUnselected(getThumbnailBackground());
		lnk.getStyle().setLinkBackgroundRolloverUnselected(getThumbnailBackground());
		Insets i = lnk.getStyle().linkBackgroundInsets;
		i.top = 0;
		i.bottom = 3;
	}
	
	@Override
	public void decoreRecordedYear(MyLink lnk)
	{
		lnk.getStyle().linkForegroundUnselected = new Color(173,173,173);
		lnk.getStyle().linkForegroundRolloverUnselected = new Color(249,249,249);
		lnk.getStyle().setLinkFont(new Font("Calibri",Font.PLAIN,14));
		lnk.getStyle().setLinkBackgroundUnselected(getThumbnailBackground());
		lnk.getStyle().setLinkBackgroundRolloverUnselected(getThumbnailBackground());
		Insets i = lnk.getStyle().linkBackgroundInsets;
		i.top = 0;
		i.bottom = 3;
	}
	
}
