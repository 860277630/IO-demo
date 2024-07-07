package com.example.gupao.Nio.demo6346;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 17:09
 **/
public class MMAPDemo {
    public static void main(String[] args) throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("E:/logo.png")
                , StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/logo_cp.png")
                , StandardOpenOption.READ,StandardOpenOption.CREATE,StandardOpenOption.WRITE);

        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] bytes = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(bytes);
        outMappedBuffer.put(bytes);
        inChannel.close();
        outChannel.close();
    }



}
