package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SmallFileTest {

    @Test
    void writeSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        byte[] bytes = "Hello World".getBytes();
        Files.write(path1, bytes);
        Assertions.assertTrue(Files.exists(path1));

        Path path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello World");
        Assertions.assertTrue(Files.exists(path2));
    }
}
