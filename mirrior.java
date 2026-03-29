import java.awt.image.BufferedImage;

public class Flip extends Converter {
  @Override
   protected BufferedImage processImage(BufferedImage image) {
        int width  = getWidth(image);
        int height = getHeight(image);
        BufferedImage result = createBlankImage(width, height);
        flipRows(image, result, width, height, 0);
        return result;
    }
   private void flipRows(BufferedImage src, BufferedImage dst, int width, int height, int y) {
        if (y >= height) return;                   
        flipColumns(src, dst, width, y, 0);        
        flipRows(src, dst, width, height, y + 1);  
    }
    private void flipColumns(BufferedImage src, BufferedImage dst, int width, int y, int x) {
        if (x >= width) return;                               
        ARGB pixel = getPixel(src, x, y);
        setPixel(dst, width - 1 - x, y, pixel);              
        flipColumns(src, dst, width, y, x + 1);             
    }
}
