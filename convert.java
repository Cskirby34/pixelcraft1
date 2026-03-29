import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public abstract class Converter {
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage original = ImageIO.read(new File(inputFileName));
        if (original == null) {
            throw new IOException("Could not read image file: " + inputFileName);
        }
        BufferedImage processed = processImage(original);
        ImageIO.write(processed, "PNG", new File(outputFileName));
        System.out.println("Saved: " + outputFileName);
    }
    protected abstract BufferedImage processImage(BufferedImage image);
    protected int getWidth(BufferedImage image) {
        return image.getWidth();
    }
 
    protected int getHeight(BufferedImage image) {
        return image.getHeight();
    }
 
    protected ARGB getPixel(BufferedImage image, int x, int y) {
        return new ARGB(image.getRGB(x, y));
    }
 
    protected void setPixel(BufferedImage image, int x, int y, ARGB argb) {
        image.setRGB(x, y, argb.toInt());
    }
 
    protected BufferedImage createBlankImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
    protected int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}
