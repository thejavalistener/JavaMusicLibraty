package app;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThumbnailExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thumbnail Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Ruta del archivo local y URL de la imagen
        String localFile = "gatito.jpg";
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1025px-Cat03.jpg";
        int sizePx = 100;

        // Crear instancia de ThmbImage
        ThmbImage thumbnail = new ThmbImage(sizePx);

        // Agregar al frame
        frame.add(thumbnail,BorderLayout.EAST);
        
        JButton btn = new JButton("Load");
        btn.addActionListener(l->{
        	thumbnail.loadImage(localFile,imageUrl);
        });

        frame.add(btn,BorderLayout.WEST);
        
        frame.setSize(650,500);
        
        
        
        // Mostrar la ventana
        frame.setVisible(true);
    }
}
