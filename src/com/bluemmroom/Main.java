package com.bluemmroom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {

        try (FileOutputStream binFIle = new FileOutputStream("data.dat");
             FileChannel binChannel = binFIle.getChannel()) {

            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        /**     Reading and Writing Java NIO
         * try {
         *             Path dataPath = FileSystems.getDefault().getPath("data.txt");
         *             Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
         *             List<String> lines = Files.readAllLines(dataPath);
         *             for (String line : lines) {
         *                 System.out.println(line);
         *             }
         *         } catch (IOException e) {
         *             e.printStackTrace();
         *         }
         */

    }
}
