package app.screen.thum;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import spotify.Album;
import spotify.Artist;
import thejavalistener.fwk.util.MyNumber;
import thejavalistener.fwk.util.string.MyString;

public class ThumPanelExample
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Thumbnail Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,450);

//		MyPanel.DEBUG_MODE = true;
		
		ThumbPanel tp = new ThumbPanel(4);
		
		frame.add(tp.c(),BorderLayout.CENTER);
		
		JButton btn=new JButton("Load");
		btn.addActionListener(l -> {
			Thumbnail t = new Thumbnail(320);
			Album album = createAlbum();
			t.setAlbum(album);
			tp.add(t);
			tp.setTitle(MyString.generateRandom('A','Z',10,15));
		});

		frame.add(btn,BorderLayout.SOUTH);

		frame.setSize(650,500);

		// Mostrar la ventana
		frame.setVisible(true);
	}
	
	public static Album createAlbum()
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
		artist.setName(MyString.generateRandom());
		artist.setSpotifyId("XXCCRRSS");

		
		int id = MyNumber.rndInt(covers.length);

		Album a=new Album();
		a.setAlbumId(id);
		a.setSportfyId("ABCDEFGHIJKLM");
		a.setTitle("Bose E' Un Capo");
		a.setMainArtist(artist);
		a.setReleasedYear(1976);
		a.setRecordedYear(1968);
		a.setCoverUrl(covers[id]);

		return a;
	}
}
