package bg.sofia.uni.fmi.mjt.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileTest {

    @Test
    void testFileConstructor() {
        File file = new File("abcd");
        assertEquals("abcd", file.getContent());
    }

    @Test
    void testFileConstructorNullContentThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new File(null), "Content is null and IllegalArgumentException must be thrown!");
    }
}
