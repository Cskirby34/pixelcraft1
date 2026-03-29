import java.awt.image.BufferedImage;

public class Grayscale extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        for (int y = 0; y < input.getHeight(); y++) {
            for (int x = 0; x < input.getWidth(); x++) {

                ARGB pixel = new ARGB(input.getRGB(x, y));

                int gray = (pixel.red + pixel.green + pixel.blue) / 3;

                ARGB newPixel = new ARGB(pixel.alpha, gray, gray, gray);

                output.setRGB(x, y, newPixel.toInt());
            }
        }
    }
}
