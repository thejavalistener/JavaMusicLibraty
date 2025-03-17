package app;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.commons.io.FileUtils;

import thejavalistener.fwk.util.MyColor;

import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

public class ThmbImage extends JLabel 
{
    private int sizePx;

	public ThmbImage(int sizePx) {
        this.sizePx = sizePx;
        this.setPreferredSize(new Dimension(sizePx, sizePx));
        setOpaque(true);
        setBackground(MyColor.random());
    }

    public void loadImage(String imgName, String imgUrl) {
        // Comienza el procesamiento en un hilo separado
        new Thread(() -> {
            try {
                File imgFile = new File(imgName);

                BufferedImage image;

                if (imgFile.exists()) {
                    // Si el archivo ya existe, lo cargamos
                    image = ImageIO.read(imgFile);

                    // Verificamos si el tamaño coincide
                    if (image.getWidth() != sizePx || image.getHeight() != sizePx) {
                        // Si no coincide, descargamos de nuevo
                        image = downloadAndResize(imgUrl, imgFile, sizePx);
                    }
                } else {
                    // Si no existe, descargamos y procesamos
                    image = downloadAndResize(imgUrl, imgFile, sizePx);
                }

                // Convierte la imagen en un ImageIcon y la muestra
                ImageIcon icon = new ImageIcon(image);
                SwingUtilities.invokeLater(() -> setIcon(icon)); // Actualiza el JLabel en el hilo de la UI

            } catch (IOException e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> setText("Error al cargar la imagen")); // Muestra un error en la UI
            }
        }).start();
    }

    // Método para descargar y redimensionar la imagen
    private BufferedImage downloadAndResize(String imgUrl, File imgFile, int sizePx) throws IOException {
        // Descarga la imagen desde la URL
        URL url = new URL(imgUrl);
        File tempFile = new File("temp_download.jpg"); // Archivo temporal

        FileUtils.copyURLToFile(url, tempFile);

        // Carga la imagen descargada
        BufferedImage image = ImageIO.read(tempFile);

        // Redimensiona la imagen al tamaño deseado
        image = resizeImage(image, sizePx, sizePx);

        // Guarda la imagen redimensionada en el archivo indicado
        ImageIO.write(image, "jpg", imgFile);

        // Limpia el archivo temporal
        tempFile.delete();

        return image;
    }

    // Método para redimensionar imágenes
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose(); // Libera recursos
        return resizedImage;
    }
}
