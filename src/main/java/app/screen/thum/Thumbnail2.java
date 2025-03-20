package app.screen.thum;

import java.awt.Color;

import javax.swing.JPanel;

import app.mapping.Album;
import thejavalistener.fwk.awt.GridLayout2;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.link.MyLinkGrid;

public class Thumbnail2 extends JPanel
{
	private Album album;
	private ThumbImage tmbImage;
	private MyLinkGrid grid;
	
	private MyLink lnkReaYear = null;
	private MyLink lnkRecYear = null;
	private MyLink lnkTitle = null;
	private MyLink lnkArtist = null;
	
	public Thumbnail2(int thumbSize)
	{
		tmbImage = new ThumbImage(thumbSize);
		
		setLayout(new GridLayout2(2,1,0,0));
		
		add(tmbImage);

		grid = new MyLinkGrid();
		grid.setBackground(Color.ORANGE);

		
		grid.setDefaultTreatment(lnk->{	
			lnk.setClickeable(true);
			lnk.getStyle().linkBackgroundRolloverUnselected = Color.RED;
			lnk.getStyle().linkForegroundRolloverUnselected = Color.BLUE;
		});		
		

		// 1ra. fila: Título, año de realización y (si lo hay) de grabación
		
		grid.addNewRow().add(" ");
		lnkTitle = grid.getJustAddedLink();
		
		grid.addNewRow().add(" ");
		lnkArtist = grid.getJustAddedLink();
		
		grid.addNewRow().add(" ");
		lnkReaYear = grid.getJustAddedLink();
		
		grid.add(" ");
		lnkRecYear = grid.getJustAddedLink();
		
		add(grid.c());
	}
	
	public void setAlbum(Album a)
	{
		this.album = a;
		tmbImage.setAlbum(a);
		
		lnkTitle.setText(a.getTitle());
		lnkArtist.setText(a.getMainArtist().getName());
		lnkReaYear.setText(a.getReleasedYear().toString());
		
		if( a.getRecordedYear()!=null )
		{
			lnkRecYear.setText(a.getRecordedYear().toString()); 
		}		
	}
	
	
	
}
