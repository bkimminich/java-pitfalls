package de.kimminich.pitfalls;

import java.io.*;

/**
 * Improved helper class for copying files with a JDK version <1.7
 */
public class ResilientFileCopyUtils {

    public static boolean copy(File from, File to) {
        try {
            return copy(new FileInputStream(from), new FileOutputStream(to));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copy(FileInputStream in, FileOutputStream out) {
        boolean success = true;
        try {
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        } finally {
            success = success && close(in);
            success = success && close(out);
        }
        return success;
    }

    private static boolean close(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
