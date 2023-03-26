package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {

    @Test
    void read() {
        Path path = Path.of("pom.xml");
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            int counter = 0;
            while((data = stream.read()) != -1){
                builder.append((char)data);
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void readBytes() {
        Path path = Path.of("pom.xml");
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] bytes = new byte[1024];
            int length;
            int counter = 0;
            while((length = stream.read(bytes)) != -1){
                builder.append(new String(bytes, 0, length));
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}
