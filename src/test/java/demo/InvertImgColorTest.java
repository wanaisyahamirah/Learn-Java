package demo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class InvertImgColorTest {
    
    @Test
	public void invertImgColor() throws IOException {

		// -- ICSInvertChqImg :: [invertImgColor] :: Value of outputImgPath ::
		// D:\tomcat\webapps\CHEQUEWORKS\file\TEMP\202212140290001000400120221214GF.JPEG
		// -- ICSInvertChqImg :: [invertImgColor] :: Value of outputImagePathInverted ::
		// D:\tomcat\webapps\CHEQUEWORKS\file\TEMP\202212140290001000400120221214GF_INVERTED.JPEG

		String outputImgPath = "D:\\tomcat\\webapps\\CHEQUEWORKS\\file\\TEMP\\202212140290001000400120221214GF.JPEG";
		String outputImagePathInverted = "D:\\tomcat\\webapps\\CHEQUEWORKS\\file\\TEMP\\202212140290001000400120221214GF_INVERTED.JPEG";

		BufferedImage inputFile = null;
		File f = null;

		try {

			f = new File(outputImgPath);

			inputFile = ImageIO.read(f);

			System.out.println("-- ICSInvertChqImg :: [invertImgColor] :: Value of img :: " + inputFile);
		} catch (IOException e) {
			throw e;
		}

		for (int x = 0; x < inputFile.getWidth(); x++) {
			for (int y = 0; y < inputFile.getHeight(); y++) {
				int rgba = inputFile.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
				inputFile.setRGB(x, y, col.getRGB());
			}
		}

		try {
			f = new File(outputImagePathInverted);
			System.out.println("-- ICSInvertChqImg :: [invertChqImgColor] :: Value of outputImagePathInverted :: " + f);

			ImageIO.write(inputFile, "png", f);
		} catch (IOException e) {
			throw e;
		}
    }

}
