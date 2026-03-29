import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Converter {
  public void convert(String inputFileName, String outputFileName) throw IOException{
    BufferedImage inputImage = ImageIO.read(new File(inputFileName));

    BufferedImage outputImage = processImage(inputImage);

    ImageIO.write(outputImage, "PNG", new File(outputFileName));
  }
  protected abstract void processImage(BufferedImage input, BufferedImage output);
  
}
