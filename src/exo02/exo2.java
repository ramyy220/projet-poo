import java.io.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * The class ImageRoot is an unfinished class which represents an image.
 * It contains a constructor which allows to load an image from a file and transform it to matrix
 * and a method which saves an image in a file.
 *
 * Objective: implement the abstract "filter" method in a derived class
 *
 * @ Gaceb/umbb, POO, TP4
 */

public abstract class exo2 {
    protected int[][] data;
    protected int width, height;

    // Constructor: load an image from a file

    /**
     * The constructor build a new image loading the contents from a file.
     * @param filename The filename from where to load the image
     */
    public ImageRoot(String filename) {
        try {
            BufferedImage tmp = ImageIO.read(new File(filename));

            // Eventually convert from color to gray
            data = new int[tmp.getWidth()][tmp.getHeight()];
            width = tmp.getHeight();
            height = tmp.getWidth();
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    int v = tmp.getRGB(x, y);
                    int r = (v & 0x00ff0000) >> 16;
                    int g = (v & 0x0000ff00) >> 8;
                    int b = (v & 0x000000ff);
                    data[x][y] =
                            (int)((double)r * 0.299 + (double)g * 0.587 + (double)b *
                                   0.114);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not read image " + filename);
        }
    }


    // Filter

    abstract public void filter(Filter f);

    /**
     *
     * @return the width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return the height of the image
     */
    public int getHeight() {
        return height;
    }

    // Save image to file
    /**
     *Save the Image into a file.
     * @param filename the filename into which to save the image.
     */
    public void save(String filename) {
        BufferedImage tmp =
            new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                int v = data[x][y];
                int v24 = v + v * 256 + v * 256 * 256;
                tmp.setRGB(x, y, v24);
            }
        }
        try {
            String extension =
                filename.substring(filename.indexOf(".") + 1, filename.length());
            ImageIO.write(tmp, extension, new File(filename));
        } catch (IOException e) {
            System.err.println("Could not write image result.png");
        }
    }
}