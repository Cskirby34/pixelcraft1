import java.awt.image.BufferedImage;

public class Invert extends Converter {
   @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width  = getWidth(image);
        int height = getHeight(image);
        BufferedImage result = createBlankImage(width, height);
        invertRows(image, result, width, height, 0);
        return result;
    }
