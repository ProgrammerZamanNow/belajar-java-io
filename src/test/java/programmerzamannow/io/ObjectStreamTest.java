package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {

    @Test
    void savePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("Eko");

        Path path = Path.of("eko.person");

        try(OutputStream stream = Files.newOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)){

            objectOutputStream.writeObject(person);
            objectOutputStream.flush();

        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }

    @Test
    void getPerson() {
        Path path = Path.of("eko.person");

        try(InputStream stream = Files.newInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(stream)){

            Person person = (Person) objectInputStream.readObject();

            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("Eko", person.getName());

        }catch (IOException | ClassNotFoundException exception){
            Assertions.fail(exception);
        }
    }
}
