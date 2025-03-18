package app.screen.thum;

import java.awt.GridLayout;

import javax.swing.JPanel;

import app.mapping.Album;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.panel.MyLeftLayout;
import thejavalistener.fwk.util.MyColor;
import thejavalistener.fwk.util.string.MyString;

public class ThumbDetails extends JPanel
{
	private Album album;
	
	private MyLink lnkReaYear;
	private MyLink lnkRecYear;
	private MyLink lnkTitle;
	private MyLink lnkArtist;
	
	public ThumbDetails()
	{	
		// 3 filas
		setLayout(new GridLayout(3,1));

		// 1ra. fila: Título, año de realización y (si lo hay) de grabación
		MyLeftLayout ll = new MyLeftLayout();
		
		// Titulo (1976, 1968) o Titulo (1976)

		lnkTitle = new MyLink("");
		lnkTitle.setOpaque(true);
		ll.add(lnkTitle.c());
		ll.add(new MyLink("|").c());		

		lnkReaYear = new MyLink("",MyLink.LINK);
		lnkReaYear.setOpaque(true);
		ll.add(lnkReaYear.c());

		lnkRecYear = new MyLink("",MyLink.LINK);
		lnkRecYear.setOpaque(true);
		ll.add(lnkRecYear.c());
		
		add(ll);
		
		
		// 2da. fila: Nombre del artista 
		lnkArtist = new MyLink("",MyLink.LINK);
		lnkArtist.setOpaque(true);
		add(lnkArtist.c());
		
		setBackground(MyColor.random());
	}
	
	public void setAlbum(Album a)
	{
		this.album = a;
		lnkTitle.setText(album.getTitle());
		lnkArtist.setText(album.getMainArtist().getName());
		lnkReaYear.setText(album.getReleasedYear().toString());
		lnkRecYear.setText(MyString.ifNull(album.getRecordedYear(),""));
	}
}
