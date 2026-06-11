package bg.sofia.uni.fmi.mjt.file.step;

import bg.sofia.uni.fmi.mjt.file.File;
import bg.sofia.uni.fmi.mjt.file.exception.EmptyFileException;
import bg.sofia.uni.fmi.mjt.file.step.CheckEmptyFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckEmptyFileTest {

    @Test
    void testProcess() {
        File file = new File("abcd");
        CheckEmptyFile checkEmptyFile = new CheckEmptyFile();
        assertEquals(file, checkEmptyFile.process(file));
    }

    @Test
    void testProcessEmptyFileContentThrowsEmptyFileException() {
        File file = new File("");
        CheckEmptyFile checkEmptyFile = new CheckEmptyFile();
        assertThrows(EmptyFileException.class, () -> checkEmptyFile.process(file), "File content is empty and EmptyFileException must be thrown!");
    }

    @Test
    void testProcessNullFileThrowsEmptyFileException() {
        CheckEmptyFile checkEmptyFile = new CheckEmptyFile();
        assertThrows(EmptyFileException.class, () -> checkEmptyFile.process(null), "File is null and EmptyFileException must be thrown!");
    }

}
