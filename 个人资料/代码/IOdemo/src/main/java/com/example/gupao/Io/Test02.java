package com.example.gupao.Io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import org.w3c.dom.Element;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-11-13 00:50
 **/
public class Test02 {
    public static void main(String[] args) throws Exception {
        FileOutputStream file = new FileOutputStream("E:/test.txt");
        String str = "hello world,How are you?";

        byte[] bys = new byte[3];

        InputStream in = new ByteArrayInputStream(str.getBytes());
        BufferedOutputStream out = new BufferedOutputStream(file);
        int len = 0;

        while ((len = in.read(bys)) != -1) {
            out.write(bys, 0, len);
        }
        in.close();
        out.close();
    }


    // 重新调整 图片的DPI
    // DPI改变了 像素数量没变 但是图片尺寸(cm)被改变了 说白了就是被缩小到了一个点 可以复制到word中查看  会发现明显变大或者变小了
    // paddle官方用的是1200dpi
    // 图像每英寸长度内的像素点数
    @Test
    public void test_01()throws Exception{
        // 指定原始图像路径
        String path = "D:/11.jpg";
        // 创建BufferedImage对象来存储原始图像
        BufferedImage image = ImageIO.read(new File(path));
        ImageWriter writer = ImageIO.getImageWritersBySuffix("jpg").next();
        ImageWriteParam writeParams = writer.getDefaultWriteParam();
        writeParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        //调整图片质量
        writeParams.setCompressionQuality(1f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
        writer.setOutput(ios);
        ImageWriteParam param = writer.getDefaultWriteParam();
        IIOMetadata metadata = writer.getDefaultImageMetadata(new ImageTypeSpecifier(image.getColorModel(), image.getSampleModel()), param);
        Element tree = (Element) metadata.getAsTree("javax_imageio_jpeg_image_1.0");
        Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);
        jfif.setAttribute("Xdensity", "300");
        jfif.setAttribute("Ydensity", "300");
        jfif.setAttribute("resUnits", "1");
        metadata.mergeTree("javax_imageio_jpeg_image_1.0", tree);
        writer.write(null, new IIOImage(image, null, metadata), param);
        writer.dispose();
        bytesToFile(baos.toByteArray());
        ios.close();
        baos.close();
        System.out.println("成功重置图像的DPI！");
    }

    //  二值化图片
    @Test
    public void test_02() throws Exception{
        String path = "D:/12.jpg";
        // 创建BufferedImage对象来存储原始图像
        BufferedImage image = ImageIO.read(new File(path));
        int threshold = 200;

        int width=image.getWidth();
        int height=image.getHeight();
        int r=0;
        BufferedImage  bufferedImageT= new BufferedImage(width,height, BufferedImage.TYPE_3BYTE_BGR );

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color color = new Color(image.getRGB(x,y));
                int gray = (color.getRed()  + color.getGreen() + color.getBlue())/3;
                //设置阈值
                if (gray >threshold){
                    r = 255;
                }else{r=0;}
                Color color_end = new Color(r,r,r);
                bufferedImageT.setRGB(x,y,color_end.getRGB());
            }
        }
        // 然后保存到本地
        File file = new File("D:\\二值化.jpg");
        ImageIO.write(bufferedImageT, "jpg", file);
    }

    //去除噪音
    // 去除噪音的方法有很多  有基于opencv、中值滤波等方法 本方法基于  领域检测法 仅适用于黑白图像
    @Test
    public void test_03() throws Exception{
        String path = "D:/二值化.jpg";
        // 创建BufferedImage对象来存储原始图像
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage grayBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                final int color = bufferedImage.getRGB(i, j);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
                int newPixel = colorToRGB(255, gray, gray, gray);
                grayBufferedImage.setRGB(i, j, newPixel);
            }
        }

        // 然后保存到本地
        File file = new File("D:\\降噪.jpg");
        ImageIO.write(grayBufferedImage, "jpg", file);
    }
    private  int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }
    //腐蚀、膨胀  效果很差  建议使用python
    @Test
    public void test_04() throws Exception{
        String path = "D:/二值化.jpg";
        // 创建BufferedImage对象来存储原始图像
        BufferedImage image = ImageIO.read(new File(path));
        int[] kernel = new int[]{1, 1};
        int black = new Color(0, 0, 0).getRGB();
        int white = new Color(255, 255, 255).getRGB();
        int w = image.getWidth();
        int h = image.getHeight();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int min = 255;
                for (int i = x; i < x + kernel[0]; i++) {
                    for (int j = y; j < y + kernel[1]; j++) {
                        if (i >= 0 && i < w && j >= 0 && j < h) {
                            int value = image.getRGB(i, j) & 0xff;
                            if (value < min) {
                                min = value;
                            }
                        }
                    }
                }
                if (min == 255) {
                    image.setRGB(x, y, white);
                } else {
                    image.setRGB(x, y, black);
                }
            }
        }
        ImageIO.write(image, "jpg", new File("erode.jpg"));

    }



    //bytes转file
    public static File bytesToFile(byte[] bytes){
        DateTimeFormatter formatStr = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formatDate = formatStr.format(LocalDateTime.now());

        String fileName  = formatDate+Thread.currentThread().getId()+".jpg";
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File("D:/imgs");
            // 判断文件目录是否存在
            if (!dir.exists() ) {
                dir.mkdirs();
            }
            file = new File("D:/imgs" + "/" + fileName);
            //输出流
            fos = new FileOutputStream(file);
            //缓冲流
            bos = new BufferedOutputStream(fos);
            //将字节数组写出
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }


}
