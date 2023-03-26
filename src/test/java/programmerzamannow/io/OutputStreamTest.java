package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {
    @Test
    void outputStream() {
        Path path = Path.of("output.txt");
        try(OutputStream stream = Files.newOutputStream(path)){
            for (int i = 0; i < 100; i++) {
                stream.write("Hello World\n".getBytes());
                stream.flush();
            }
        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
