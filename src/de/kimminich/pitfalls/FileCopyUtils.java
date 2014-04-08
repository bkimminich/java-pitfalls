package de.kimminich.pitfalls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Helper class for copying files with a JDK version <1.7
 */
public class FileCopyUtils {

    public static void copy(File from, File to) {
        try {
            copy(new FileInputStream(from), new FileOutputStream(to));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(FileInputStream in, FileOutputStream out) {
        try {
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

}
