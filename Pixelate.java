import java.awt.image.BufferedImage;

public class Pixelate extends Converter {

    private static final int BLOCK_SIZE = 12;
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width  = getWidth(image);
        int height = getHeight(image);
        BufferedImage result = createBlankImage(width, height);

        for (int blockY = 0; blockY < height; blockY += BLOCK_SIZE) {
            for (int blockX = 0; blockX < width; blockX += BLOCK_SIZE) {

                int sumA = 0, sumR = 0, sumG = 0, sumB = 0, count = 0;

                for (int dy = 0; dy < BLOCK_SIZE && blockY + dy < height; dy++) {
                    for (int dx = 0; dx < BLOCK_SIZE && blockX + dx < width; dx++) {
                        ARGB p = getPixel(image, blockX + dx, blockY + dy);
                        sumA += p.alpha; sumR += p.red;
                        sumG += p.green; sumB += p.blue;
                        count++;
                    }
                }

                ARGB avg = new ARGB(sumA / count, sumR / count, sumG / count, sumB / count);

                for (int dy = 0; dy < BLOCK_SIZE && blockY + dy < height; dy++) {
                    for (int dx = 0; dx < BLOCK_SIZE && blockX + dx < width; dx++) {
                        setPixel(result, blockX + dx, blockY + dy, avg);
                    }
                }
            }
        }
        return result;
    }
}
