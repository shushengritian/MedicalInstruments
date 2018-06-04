package com.graduate.utils.qrcode;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author xiyouquedongxing
 * @date 2018/4/24 15:49
 */
public class MatrixToImageWriter {

    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;

    public MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x = 0;x < width;x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x,y,matrix.get(x,y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static BufferedImage writeToFile(BitMatrix matrix,String format)
            throws IOException {

        BufferedImage image = toBufferedImage(matrix);
        return image;
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    /**
     * 二维码添加logo
     * */
    public static BufferedImage addLogoQrcode(BufferedImage barCodeImage, File logoPic,LogoConfig logoConfig) {
        try {
            if (!logoPic.isFile()) {
                System.out.println("没找到file！");
                throw new IOException("没找到file！");
            }

            /**
             * 读取二维码图片，构建绘图对象
             * */
            Graphics2D g = barCodeImage.createGraphics();

            /**
             * 获取logo图片
             * */
            BufferedImage logo = ImageIO.read(logoPic);

            //保持二维码是正方形的
            int widthLogo = barCodeImage.getWidth() / logoConfig.getLogoPart();
            int heightLogo = barCodeImage.getWidth() / logoConfig.getLogoPart();

            // 计算图片放置位置
            int x = (barCodeImage.getWidth() - widthLogo) / 2;
            int y = (barCodeImage.getHeight() - heightLogo) / 2;


            //开始绘制图片
            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
            g.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
            g.setStroke(new BasicStroke(logoConfig.getBorder()));
            g.setColor(logoConfig.getBorderColor());
            g.drawRect(x, y, widthLogo, heightLogo);

            g.dispose();
            return barCodeImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
