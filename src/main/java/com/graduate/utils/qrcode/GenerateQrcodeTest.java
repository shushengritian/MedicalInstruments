package com.graduate.utils.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/4/24 17:47
 */
public class GenerateQrcodeTest {

    @Resource
    MultiFormatWriter multiFormatWriter;


    private static String content = "无聊的人会死亡！";
    //生成所在文件夹
    private static String path = "C:/Users/Administrator/Desktop/Qrcode";

    public static void main(String[] args) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            @SuppressWarnings("rawtypes")
            Map hints = new HashMap(10);
            //设置编码格式
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            //设置周五白色区域大小
            hints.put(EncodeHintType.MARGIN,2);
            //设置二维码容错率
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            //width:图片完整的宽;height:图片完整的高
            int width = 500;
            int height = 500;

            //画二维码，记得调用multiFormatWriter.encode()时最后要带上hints参数，不然上面设置无效
            BitMatrix bitMatrix = multiFormatWriter.encode(content,BarcodeFormat.QR_CODE,width,height,hints);

            //qrcFile用来存放生成的二维码图片（无logo，无文字）
            File logoFile = new File(path,"logo.jpg");

            //开始画二维码
            BufferedImage barCodeImage = MatrixToImageWriter.writeToFile(bitMatrix, "jpg");

            //在二维码加入logo图片
            LogoConfig logoConfig = new LogoConfig();
            BufferedImage image = MatrixToImageWriter.addLogoQrcode(barCodeImage,logoFile,logoConfig);

            //用来存放带有logo+文字的二维码图片
            String newImageWithText = path + "/QR_code.jpg";

            FileOutputStream out = new FileOutputStream(newImageWithText);
            ImageIO.write(image, "JPEG", out);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
            System.out.println("image press success");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
