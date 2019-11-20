import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ColorWheel extends JComponent {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(this.drawMe(), new AffineTransform(1f,0f,0f,1f,1,1), null);

		
	}
	

	   @Override
	    public Dimension getPreferredSize() {
		   JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	        return new Dimension((int) (topFrame.getWidth()*.28), getHeight());
	    }
	
	public BufferedImage drawMe() {
	  int rad = (int) (getWidth()*.9);
      BufferedImage img = new BufferedImage(rad, rad, BufferedImage.TYPE_INT_RGB);

      // Center Point (MIDDLE, MIDDLE)
      int centerX = img.getWidth() / 2;
      int centerY = img.getHeight() / 2;
      int radius = (img.getWidth() / 2) * (img.getWidth() / 2);

      // Red Source is (RIGHT, MIDDLE)
      int redX = img.getWidth();
      int redY = img.getHeight() / 2;
      int redRad = img.getWidth() * img.getWidth();

      // Green Source is (LEFT, MIDDLE)
      int greenX = 0;
      int greenY = img.getHeight() / 2;
      int greenRad = img.getWidth() * img.getWidth();

      // Blue Source is (MIDDLE, BOTTOM)
      int blueX = img.getWidth() / 2;
      int blueY = img.getHeight();
      int blueRad = img.getWidth() * img.getWidth();

      for (int i = 0; i < img.getWidth(); i++) {
          for (int j = 0; j < img.getHeight(); j++) {
              int a = i - centerX;
              int b = j - centerY;

              int distance = a * a + b * b;
              if (distance < radius) {
                  int rdx = i - redX;
                  int rdy = j - redY;
                  int redDist = (rdx * rdx + rdy * rdy);
                  int redVal = (int) (255 - ((redDist / (float) redRad) * 256));

                  int gdx = i - greenX;
                  int gdy = j - greenY;
                  int greenDist = (gdx * gdx + gdy * gdy);
                  int greenVal = (int) (255 - ((greenDist / (float) greenRad) * 256));

                  int bdx = i - blueX;
                  int bdy = j - blueY;
                  int blueDist = (bdx * bdx + bdy * bdy);
                  int blueVal = (int) (255 - ((blueDist / (float) blueRad) * 256));

                  Color c = new Color(redVal, greenVal, blueVal);

                  float hsbVals[] = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);

                  Color highlight = Color.getHSBColor(hsbVals[0], hsbVals[1], 1);

                  img.setRGB(i, j, RGBtoHEX(highlight));
              } else {
                  img.setRGB(i, j, 0xFFFFFF);
              }
          }
      }

      try {
          ImageIO.write(img, "png", new File("wheel.png"));
          System.out.println("IMG CREATED ");
          return img;
      } catch (IOException e) {
          e.printStackTrace();
          return null;
      }
  }


  public static int RGBtoHEX(Color color) {
      String hex = Integer.toHexString(color.getRGB() & 0xffffff);
      if (hex.length() < 6) {
          if (hex.length() == 5)
              hex = "0" + hex;
          if (hex.length() == 4)
              hex = "00" + hex;
          if (hex.length() == 3)
              hex = "000" + hex;
      }
      hex = "#" + hex;
      return Integer.decode(hex);
  }

}
