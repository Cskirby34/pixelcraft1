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
    private void invertrows(BufferedImage src, BufferedImage dst, int width, int height, int y) {
       if (y >= height) return;
        invertColumns(src, dst, width, y, 0);
        invertRows(src, dst, width, height, y + 1);
    }
    private void invertColumns(BufferedImage src, BufferedImage dst, int width, int y, int x) {
        if (x >= width) return;
           ARGB p = getPixel(src, x, y);
           setPixel(dst, x, y, new ARGB(p.alpha, 255 - p.red, 255 - p.green, 255 - p.blue));
           invertColumns(src, dst, width, y, x + 1);
    }
}
