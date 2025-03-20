package app.screen.thum;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import spotify.Album;
import spotify.Artist;
import thejavalistener.fwk.awt.panel.MyPanel;
import thejavalistener.fwk.util.reflect.MyPackage;

public class ThumbnailExample
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Thumbnail Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,450);

		MyPanel.DEBUG_MODE = true;
		
		// Crear instancia de ThmbImage
		int sizePx=350;
		Thumbnail2 thumbnail=new Thumbnail2(sizePx);

		// Agregar al frame
		JPanel p=new JPanel();
		p.add(thumbnail);
		frame.add(p,BorderLayout.CENTER);

		JButton btn=new JButton("Load");
		btn.addActionListener(l -> {
			
			Album album = createAlbum();
			thumbnail.setAlbum(album);
		});

		frame.add(btn,BorderLayout.WEST);

		frame.setSize(650,500);

		// Mostrar la ventana
		frame.setVisible(true);
	}
	
	public static Album createAlbum()
	{
		Artist artist=new Artist();
		artist.setArtistId(1);
		artist.setName("Roberto Calos");
		artist.setSpotifyId("XXCCGGRR");

		Album a=new Album();
		a.setAlbumId(1);
		a.setSportfyId("ABCDEFGHIJKLM");
		a.setTitle("Bose E' Un Capo");
		a.setMainArtist(artist);
		a.setReleasedYear(1976);
		a.setRecordedYear(1968);
		a.setCoverUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1025px-Cat03.jpg");

		return a;
	}
}
