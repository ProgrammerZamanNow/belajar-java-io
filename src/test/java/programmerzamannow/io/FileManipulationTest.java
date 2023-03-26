package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManipulationTest {

    @Test
    void fileManipulation() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void directoryManipulation() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);
        Assertions.assertTrue(Files.isDirectory(path));
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
