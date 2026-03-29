import java.awt.image.BufferedImage;

public class Rotate extends Converter {
  @Override
  protected BufferedImage processImage(BufferedImage image) {
    int scrwidth=getWidth(image);
    int scrheight=getHeight(image);
    BufferedImage result = createBlankImage(srcHeight, srcWidth);

    for (int y = 0; y < srcHeight; y++) {
            for (int x = 0; x < srcWidth; x++) {
                ARGB pixel = getPixel(image, x, y);
                // 90° CW: new_x = (srcHeight - 1 - y), new_y = x
                setPixel(result, srcHeight - 1 - y, x, pixel);
            }
        }
        return result;
    }
}



 

  
