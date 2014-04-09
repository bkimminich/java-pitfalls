package de.kimminich.pitfalls;

import java.io.*;

/**
 * Helper class for copying files with a JDK version <1.7
 */
public class FileCopyUtilsFixed {

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
            close(in);
            close(out); // previously, if closing in failed, out would never be closed either
        }
    }

    /* Assuming you cannot move to at least Java 7 and use try-with-resource this is a possible workaround */
    private static void close(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException ignore) {
        }
    }

}
