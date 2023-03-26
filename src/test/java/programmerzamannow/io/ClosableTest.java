package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosableTest {

    @Test
    void closeIO() {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
            // lakukan apapun dengan input stream
        }catch (IOException exception){
            Assertions.fail(exception);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    @Test
    void closeIOWithTryResource() {
        Path path = Path.of("pom.xml");
        try(InputStream inputStream = Files.newInputStream(path);
            InputStream inputStream2 = Files.newInputStream(path);
            InputStream inputStream3 = Files.newInputStream(path)) {
            // lakukan apapun dengan input stream
        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
