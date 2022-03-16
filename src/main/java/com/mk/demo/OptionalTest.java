package com.mk.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Mckay
 * @create 2019-12-10
 * @description
 **/
public class OptionalTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("./data.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.put("hello".getBytes());
        buffer.flip();
        fileChannel.write(buffer);

        file.close();

    }

    public static boolean compare(int a, int b) {
        return a > b;
    }

    public static boolean compare(float a, float b) {
        return a > b;
    }
}
