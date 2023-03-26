package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {

    @Test
    void createFile() {
        File file = new File("file.txt");

        Assertions.assertEquals("file.txt", file.getName());
        Assertions.assertFalse(file.exists());
    }

    @Test
    void createFileExists() {
        File file = new File("src/main/resources/application.properties");

        Assertions.assertEquals("application.properties", file.getName());
        Assertions.assertTrue(file.exists());
    }
}
