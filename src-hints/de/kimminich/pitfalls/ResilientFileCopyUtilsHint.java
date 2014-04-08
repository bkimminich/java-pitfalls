package de.kimminich.pitfalls;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

public class ResilientFileCopyUtilsHint {

    @Rule
    public TemporaryFolder fileSystem = new TemporaryFolder();

    @Test(expected = IOException.class)
    public void passingCopy() throws Exception {
        FileInputStream in = spy(new FileInputStream(fileSystem.newFile()));
        FileOutputStream out = new FileOutputStream(fileSystem.newFile());

        ResilientFileCopyUtils.copy(in, out);

        out.write(1);
    }

    @Test
    public void failingCopy() throws Exception {
        FileInputStream in = spy(new FileInputStream(fileSystem.newFile()));
        doThrow(IOException.class).when(in).close();
        FileOutputStream out = new FileOutputStream(fileSystem.newFile());

        ResilientFileCopyUtils.copy(in, out);

        out.write(1);
    }
}
