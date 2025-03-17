package app;

import javax.swing.JFrame;

public class ThumbnailExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thumbnail Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Ruta del archivo local y URL de la imagen
        String localFile = "gatito.jpg";
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1025px-Cat03.jpg";
        int sizePx = 450;

        // Crear instancia de ThmbImage
        ThmbImage thumbnail = new ThmbImage(localFile, imageUrl, sizePx);

        // Agregar al frame
        frame.add(thumbnail);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
