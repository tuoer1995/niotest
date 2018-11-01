package com.ly.test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * description:管道测试
 *
 * @author: tuoer
 * @date： 2018/10/29
 */
public class ChannelTest {
    public static void main(String[] args) {

        try {

            RandomAccessFile rf = new RandomAccessFile("", "");
            FileChannel channel = rf.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(48);
            int read = channel.read(allocate);

            while (read != -1) {
                System.out.println("Read"+read);
                allocate.flip();

                while (allocate.hasRemaining()) {
                    System.out.println((char) allocate.get());
                }

                allocate.clear();
                read = channel.read(allocate);
            }
        } catch (Exception e) {

        }

    }
}
