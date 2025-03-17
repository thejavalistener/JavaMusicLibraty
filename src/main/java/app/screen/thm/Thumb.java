package app.screen.thm;

import java.awt.BorderLayout;

import app.ThmbDetails;
import app.ThmbImage;
import app.mapping.Album;
import thejavalistener.fwk.awt.panel.MyBorderLayout;

public class Thumb extends MyBorderLayout
{
	private Album album;
	private ThmbDetails tmbDetails;
	private ThmbImage tmbImage;
	
	public Thumb()
	{
		tmbImage = new ThmbImage(350);
		add(tmbImage,BorderLayout.CENTER);
		
		tmbDetails = new ThmbDetails();
	}
	
	public void setAlbum(Album a)
	{
		this.album = a;
		String ln1 = album.getTitle();
		String ln2 = album.getMainArtist().getName();
		
		Integer relY = album.getReleasedYear();
		Integer recY = album.getRecordedYear();	
		String ln3 = relY + (recY!=null?" ("+recY+")":"");
		
		String imgUrl = album.getCoverUrl();
		tmbDetails.setDetails(ln1,ln2,ln3);
		tmbImage.loadImage("gatito.jpg",imgUrl);
		
	}
	
	
	
}
