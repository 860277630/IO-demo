package com.example.gupao.Io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-24 15:00
 **/
public class Test {
    public static void main(String[] args) throws Exception{
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream("E:/1.jpg"));
        BufferedImage image = RotateImageUtil.rotateImage(bufferedImage, 180);
        File outputfile = new File("image.jpg");
        ImageIO.write(image, "jpg", outputfile);
    }



}
