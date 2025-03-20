package app.screen.thum;

import java.awt.BorderLayout;

import app.mapping.Album;
import thejavalistener.fwk.awt.panel.MyBorderLayout;

public class Thumbnail extends MyBorderLayout
{
	private Album album;
	private ThumbImage tmbImage;
	private ThumbDetails tmbDetails;
	
	public Thumbnail(int thumbSize)
	{
		tmbImage = new ThumbImage(thumbSize);
		add(tmbImage,BorderLayout.CENTER);
		
		tmbDetails = new ThumbDetails();
		add(tmbDetails.c(),BorderLayout.SOUTH);
	}
	
	public void setAlbum(Album a)
	{
		this.album = a;
		tmbImage.setAlbum(a);
		tmbDetails.setAlbum(a);
		
	}
	
	
	
}
