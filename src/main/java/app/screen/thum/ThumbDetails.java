package app.screen.thum;

import java.awt.Color;
import java.awt.Component;

import spotify.Album;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.link.MyLinkGrid;

public class ThumbDetails 
{
	private MyLinkGrid grid;
	
	private Album album;
	private Color background = Color.GREEN;
	
	private MyLink lnkReaYear = null;
	private MyLink lnkRecYear = null;
	private MyLink lnkTitle = null;
	private MyLink lnkArtist = null;
	
	public ThumbDetails()
	{	
		grid = new MyLinkGrid();
	}
	
	public void setAlbum(Album a)
	{
		this.album = a;
		
		grid.setDefaultTreatment(lnk->{	
			lnk.setClickeable(true);
			lnk.getStyle().linkBackgroundRolloverUnselected = background;
			lnk.getStyle().linkForegroundRolloverUnselected = Color.BLUE;
		});		
		
		// armo el grid 

		// 1ra. fila: Título, año de realización y (si lo hay) de grabación
		
		grid.addNewRow().add(a.getTitle());
		lnkTitle = grid.getJustAddedLink();
		
		grid.addNewRow().add(a.getMainArtist().getName());
		lnkArtist = grid.getJustAddedLink();
		
		grid.addNewRow().add(a.getReleasedYear().toString());
		lnkReaYear = grid.getJustAddedLink();
		
		if( a.getRecordedYear()!=null )
		{
			grid.add(a.getRecordedYear().toString());
			lnkRecYear = grid.getJustAddedLink();
		}		
	}
	
	public Component c()
	{
		return grid.c();
	}
}
