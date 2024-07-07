package com.example.gupao.Nio.bufferDemo;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2024-01-01 20:43
 **/
public class BuffferDemo {
    public static void main(String[] args) {
        System.out.println("初始化一个缓冲区");
        LongBuffer buffer  = LongBuffer.allocate(10);
        buffer.put(new long[]{1l,2l,3l,4l,5l});
        System.out.println("容量："+buffer.capacity()+"===position："+buffer.position()+"===limit："+buffer.limit()+"===数据："+ Arrays.toString(buffer.array()));
        buffer.get();
        System.out.println("容量："+buffer.capacity()+"===position："+buffer.position()+"===limit："+buffer.limit()+"===数据："+ Arrays.toString(buffer.array()));
        buffer.flip();
        System.out.println("容量："+buffer.capacity()+"===position："+buffer.position()+"===limit："+buffer.limit()+"===数据："+ Arrays.toString(buffer.array()));
        buffer.get();
        System.out.println("容量："+buffer.capacity()+"===position："+buffer.position()+"===limit："+buffer.limit()+"===数据："+ Arrays.toString(buffer.array()));
        buffer.put(new long[]{6l,7l,8l});
        buffer.flip();
        System.out.println("容量："+buffer.capacity()+"===position："+buffer.position()+"===limit："+buffer.limit()+"===数据："+ Arrays.toString(buffer.array()));

    }

    @Test
    public void test_01(){
        LongBuffer buffer  = LongBuffer.allocate(10);
        buffer.put(new long[]{1l,2l,3l,4l,5l});
        System.out.println("capacity："+buffer.capacity());
        System.out.println("position："+buffer.position());
        System.out.println("limit："+buffer.limit());
        System.out.println("数据："+ Arrays.toString(buffer.array()));
    }

    @Test
    public void test_02(){
        LongBuffer buffer  = LongBuffer.allocate(7);
        System.out.println("position："+buffer.position());
        buffer.put(new long[]{1l,2l,3l,4l,5l});
        System.out.println("position："+buffer.position());
        buffer.put(new long[]{6l});
        System.out.println("position："+buffer.position());
    }

    @Test
    public void test_03(){
        LongBuffer buffer  = LongBuffer.allocate(7);
        buffer.put(new long[]{1l,2l,3l,4l,5l});
        System.out.println("position："+buffer.position());
        //翻转
        buffer.flip();

        System.out.println("position："+buffer.position());
        System.out.println("获取数据："+buffer.get()+"===position："+buffer.position());
        System.out.println("获取数据："+buffer.get()+"===position："+buffer.position());
    }

    @Test
    public void test_04(){
        ByteBuffer byteBuffer_01 = ByteBuffer.allocate(10);

        byte[] bytes = new byte[10];
        ByteBuffer byteBuffer_02 = ByteBuffer.wrap(bytes);
    }

}
