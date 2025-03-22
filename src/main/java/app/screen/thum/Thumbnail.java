package app.screen.thum;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;

import org.hibernate.internal.build.AllowSysOut;

import spotify.Album;
import spotify.Artist;
import thejavalistener.fwk.awt.GridLayout2;
import thejavalistener.fwk.awt.link.MyLink;
import thejavalistener.fwk.awt.link.MyLinkGrid;
import thejavalistener.fwk.awt.panel.MyInsets;
import thejavalistener.fwk.awt.panel.ThumbnailDecorator;
import thejavalistener.fwk.awt.testui.MyTestUI;
import thejavalistener.fwk.util.MyNumber;

public class Thumbnail 
{
	private Album album;
	
	private MyLink lnkReaYear = null;
	private MyLink lnkRecYear = null;
	private MyLink lnkTitle = null;
	private MyLink lnkArtist = null;

	private JPanel contentPane;
	private ThumbImage tmbImage;
	private MyLinkGrid grid;

	private ThumbnailDecorator decorator = null;
	
	public Thumbnail(int thumbSize)
	{
		tmbImage = new ThumbImage(thumbSize);
		
		contentPane = new JPanel(new GridLayout2(2,1,0,0));
		
		contentPane.add(tmbImage);

		grid = new MyLinkGrid();

		// 1ra. fila: Título, año de realización y (si lo hay) de grabación
		
		grid.addNewRow().add(" ");
		lnkTitle = grid.getJustAddedLink();
		
		grid.addNewRow().add(" ");
		lnkArtist = grid.getJustAddedLink();
		lnkArtist.setClickeable(true);
		
		grid.addNewRow().add(" ");
		lnkReaYear = grid.getJustAddedLink();
		lnkReaYear.setClickeable(true);

		grid.add(" ");
		lnkRecYear = grid.getJustAddedLink();
		lnkRecYear.setClickeable(true);

		contentPane.add(grid.c());
	}
	
	public void setDecorator(ThumbnailDecorator decorator)
	{
		this.decorator = decorator;
	}
	
//	public void setStyleX(ThumbnailStyle ts)
//	{
//		this.style = ts;
//		grid.setBackground(ts.background);
//		contentPane.setBackground(ts.background);
//
//		// titulo
//		MyInsets.adjust(lnkTitle.getStyle().linkBackgroundInsets,3,0,0,0);
//		Font fnt = new Font(ts.fontName, Font.BOLD, ts.titleFontSize);
//		_setLinkStyle(lnkTitle,ts.background,ts.linkRolloverColor,ts.linkRolloverColor,fnt);
//		
//		// artista
//		MyInsets.adjust(lnkArtist.getStyle().linkBackgroundInsets,-4,0,0,0);
//		fnt = new Font(ts.fontName, Font.PLAIN, ts.artistFontSize);
//		_setLinkStyle(lnkArtist,ts.background,ts.linkColor,ts.linkRolloverColor,fnt);
//		
//		// released
//		fnt = new Font(ts.fontName, Font.PLAIN, ts.yearsFontSize);
//		_setLinkStyle(lnkReaYear,ts.background,ts.linkColor,ts.linkRolloverColor,fnt);
//		
//		// recorded
//		fnt = new Font(ts.fontName, Font.PLAIN, ts.yearsFontSize);
//		_setLinkStyle(lnkRecYear,ts.background,ts.linkColor,ts.linkRolloverColor,fnt);
//	}
//
//	private void _setLinkStyle(MyLink lnk,Color bg,Color lnkColor,Color lnkRolledOverColor,Font fnt)
//	{
//		lnk.getStyle().linkFont = fnt;
//		lnk.getStyle().background = bg;
//		lnk.getStyle().linkBackgroundUnselected = bg;		
//		lnk.getStyle().linkBackgroundRolloverUnselected = bg;		
//		lnk.getStyle().linkForegroundUnselected = lnkColor;
//		lnk.getStyle().linkForegroundRolloverUnselected = lnkRolledOverColor;	
//		//lnk.getStyle().linkBackgroundInsets = new Insets(0,0,0,0);
//		lnk.c().validate();
//	}

	public void setAlbum(Album a)
	{
		this.album = a;
		tmbImage.setAlbum(a);

		grid.setBackground(decorator.getThumbnailBackground());
		contentPane.setBackground(decorator.getThumbnailBackground());

		
		decorator.decoreTitle(lnkTitle);
		lnkTitle.c().validate();
		
		decorator.decoreArtist(lnkArtist);
		lnkArtist.c().validate();

		decorator.decoreReleasedYear(lnkReaYear);
		lnkReaYear.c().validate();

		decorator.decoreRecordedYear(lnkRecYear);
		lnkRecYear.c().validate();

		lnkTitle.setText(a.getTitle());
		lnkArtist.setText(a.getMainArtist().getName());
		lnkReaYear.setText(a.getReleasedYear().toString());
		
		if( a.getRecordedYear()!=null )
		{
			lnkRecYear.setText(a.getRecordedYear().toString()); 
		}		
	}
	
	public Component c()
	{
		return contentPane;
	}
		
	public static Album createDemoAlbum()
	{
		String[] covers = { 
				"https://hips.hearstapps.com/hmg-prod/images/eyj0exaioijkv1qilcjhbgcioijiuzi1nij9-eyjpbsi6wyjcl2fydhdvcmtcl2ltywdlrmlszvwvnwrlnduwmddkmje0mc5qcgcilcjyzxnpemusmtawmcjdfq-z1im-vmcm1-bqqxzpzkyxuqdmkhbzeanywzrbvzldlm-1669121479.jpg"
			    ,"https://cdn-images.dzcdn.net/images/cover/3c1ebf7765293ec02d3aa124aadb258c/0x1900-000000-80-0-0.jpg"
			    ,"https://akamai.sscdn.co/uploadfile/letras/albuns/2/1/5/8/26631686315643.jpg"
			    ,"https://www.udiscovermusica.com/wp-content/uploads/sites/7/2022/12/The-Beatles-Let-It-Be-album-cover-820-1536x1536-1.jpeg"
			    ,"https://cdn-images.dzcdn.net/images/cover/43504743d2efb7092130f1e2340e1ffa/0x1900-000000-80-0-0.jpg"
			    ,"https://cdn-images.dzcdn.net/images/cover/aa94ab293730bb7845d2aa8c672b2c29/500x500-000000-80-0-0.jpg"
		};

		Artist artist=new Artist();
		artist.setArtistId(1);
		artist.setName("Astrud Gilberto");
		artist.setSpotifyId("XXCCRRSS");

		
		int id = MyNumber.rndInt(covers.length);

		Album a=new Album();
		a.setAlbumId(id);
		a.setSportfyId("ABCDEFGHIJKLM");
		a.setTitle("A Certain Smile, A Certai...");
		a.setMainArtist(artist);
		a.setReleasedYear(1976);
		a.setRecordedYear(1968);
		a.setCoverUrl(covers[id]);
		
		return a;
	}
	
	public static void main(String[] args)
	{
		Thumbnail th = new Thumbnail(350);
		th.setDecorator(new ThumbnailDecorator()
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
				i.bottom = 5;
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
				i.bottom = 5;
			}
			
		});

		th.setAlbum(Thumbnail.createDemoAlbum());
		MyTestUI.test(th.c()).pack().run();
	}

}
