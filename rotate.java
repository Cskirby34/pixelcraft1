import java.awt.image.BufferedImage;

public class Rotate extends Converter {

    @Override
    protected BufferedImage processImage(BufferedImage input) {
        int srcWidth = input.getWidth();
        int srcHeight = input.getHeight();
        BufferedImage output = new BufferedImage(srcHeight, srcWidth, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < srcHeight; y++) {
            for (int x = 0; x < srcWidth; x++) {
                ARGB pixel = new ARGB(input.getRGB(x, y));
                output.setRGB(srcHeight - 1 - y, x, pixel.toInt());
            }
        }
        return output;
    }
}
